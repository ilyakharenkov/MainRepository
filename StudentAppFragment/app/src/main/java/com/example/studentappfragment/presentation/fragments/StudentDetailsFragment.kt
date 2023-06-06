package com.example.studentappfragment.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.example.studentappfragment.R
import com.example.studentappfragment.data.di.Di
import com.example.studentappfragment.data.models.Information
import com.example.studentappfragment.databinding.FragmentStudentDetailsBinding
import com.example.studentappfragment.presentation.mvvm.StudentDetailsViewModel
import com.example.studentappfragment.presentation.mvvm.StudentDetailsViewModelFactory
import com.example.studentappfragment.presentation.mvvm.StudentListViewModel
import com.example.studentappfragment.presentation.navigator
import org.koin.androidx.viewmodel.ext.android.viewModel

private const val KEY_ID = "KEY_ID"

class StudentDetailsFragment : Fragment() {

    private lateinit var binding: FragmentStudentDetailsBinding
    private val viewModel: StudentDetailsViewModel by viewModels {
        StudentDetailsViewModelFactory(studentRepository = Di.listRepositoryImpl!!)
    }

    //Вариант с Koin
    private val viewModelKoin: StudentDetailsViewModel by viewModel<StudentDetailsViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            viewModel.initIdStudent(id = requireArguments().getInt(KEY_ID))
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentStudentDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.initInformationStudent()
        viewModel.informStudent.observe(viewLifecycleOwner) {
            fillDetailsStudent(it)
        }
        initButton()
    }

    private fun initButton() {
        binding.btnEditProfile.setOnClickListener {
            viewModel.idStudent.observe(viewLifecycleOwner) {
                navigator().navigationToUpdateStudent(
                    id = it
                )
            }
        }
        binding.tvDeleteProfile.setOnClickListener {
            viewModel.delete()
            navigator().back()
        }
        binding.btnBackProfile.setOnClickListener {
            navigator().back()
        }
    }

    //заполнение компонентов TextView данными о студенте
    private fun fillDetailsStudent(information: Information) {
        Glide
            .with(binding.imViewAvatarProfile.context)
            .load(information.urlImage)
            .circleCrop()
            .placeholder(R.drawable.ic_avatar_student)
            .error(R.drawable.ic_avatar_student)
            .into(binding.imViewAvatarProfile)
        binding.nameStudentProfile.text = information.name
        binding.ageStudentProfile.text = information.age.toString()
    }

    companion object {
        @JvmStatic
        fun newInstance(id: Int): StudentDetailsFragment {
            val args = Bundle()
            args.putInt(KEY_ID, id)
            val fragment = StudentDetailsFragment()
            fragment.arguments = args
            return fragment
        }
    }

}