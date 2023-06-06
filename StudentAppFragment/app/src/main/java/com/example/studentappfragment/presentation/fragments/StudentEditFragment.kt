package com.example.studentappfragment.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.studentappfragment.data.di.Di
import com.example.studentappfragment.data.models.Information
import com.example.studentappfragment.databinding.FragmentStudentEditBinding
import com.example.studentappfragment.presentation.mvvm.StudentEditViewModel
import com.example.studentappfragment.presentation.mvvm.StudentEditViewModelFactory
import com.example.studentappfragment.presentation.mvvm.StudentListViewModel
import com.example.studentappfragment.presentation.navigator
import org.koin.androidx.viewmodel.ext.android.viewModel

private const val KEY_ID = "KEY_ID"

private const val KEY_MODE = "KEY_MODE"
private const val MODE_CREATE = "MODE_CREATE"
private const val MODE_UPDATE = "MODE_REFACTOR"

class StudentEditFragment : Fragment() {

    private lateinit var binding: FragmentStudentEditBinding
    private val viewModel: StudentEditViewModel by viewModels {
        StudentEditViewModelFactory(studentRepository = Di.listRepositoryImpl!!)
    }

    //Вариант с Koin
    private val viewModelKoin: StudentEditViewModel by viewModel<StudentEditViewModel>()

    private var mode: String = ""

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentStudentEditBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initMode()
        initButton()
    }

    private fun initButton() {
        binding.btnBackProfile.setOnClickListener {
            navigator().back()
        }
    }

    //Определяем с какого фрагмента мы пришли с какого фрагменты мы пришли
    private fun initMode() {
        arguments?.let {
            mode = it.getString(KEY_MODE).toString()
            when (mode) {
                MODE_CREATE -> {
                    createModeStudent()
                }
                MODE_UPDATE -> {
                    viewModel.initInformationStudent(id = it.getInt(KEY_ID))
                    viewModel.information.observe(viewLifecycleOwner) { information ->
                        resultInformationDetails(information = information)
                    }
                    updateModeStudent()
                }
                else -> {
                    navigator().back()
                }
            }
        }
    }

    private fun createModeStudent() {
        binding.btnSaveEdit.setOnClickListener {
            if (validationEditText()) {
                createStudent()
                navigator().back()
            }
        }
    }

    private fun updateModeStudent() {
        binding.btnSaveEdit.setOnClickListener {
            if (validationEditText()) {
                updateStudent()
                navigator().back()
            }
        }
    }

    //Заполнение компонентов EditText если мы перешли с StudentDetailsFragment
    private fun resultInformationDetails(information: Information) {
        binding.editProfilePhoto.setText(information.urlImage)
        binding.editProfileName.setText(information.name)
        binding.editProfileAge.setText(information.age.toString())
    }

    private fun createStudent() {
        viewModel.createStudent(information = fillInformationStudent())
    }

    private fun updateStudent() {
        viewModel.updateStudent(information = fillInformationStudent())
    }


    //Заполнение полей информацией для редактирования или создания студента
    private fun fillInformationStudent(): Information {
        return Information(
            urlImage = binding.editProfilePhoto.text.toString(),
            name = binding.editProfileName.text.toString(),
            age = binding.editProfileAge.text.toString().toInt()
        )
    }

    private fun validationEditText(): Boolean {
        var error = ""
        if (binding.editProfileName.text.isEmpty()) {
            error = "Empty name"
            binding.editProfileName.error = error
        }
        if (binding.editProfileAge.text.isEmpty()) {
            error = "Empty age"
            binding.editProfileAge.error = error
        }
        return error.isEmpty()
    }

    companion object {
        //Вызываем этот метод если переходим с StudentDetailsFragment
        @JvmStatic
        fun startFragmentRefactor(id: Int): StudentEditFragment {
            val args = Bundle()
            args.putString(KEY_MODE, MODE_UPDATE)
            args.putInt(KEY_ID, id)
            val fragment = StudentEditFragment()
            fragment.arguments = args
            return fragment
        }

        //Вызываем этот метод если переходим с StudentListFragment
        @JvmStatic
        fun startFragmentCreate(): StudentEditFragment {
            val args = Bundle()
            args.putString(KEY_MODE, MODE_CREATE)
            val fragment = StudentEditFragment()
            fragment.arguments = args
            return fragment
        }
    }
}