package com.example.studentappfragment.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.studentappfragment.data.di.Di
import com.example.studentappfragment.databinding.FragmentStudentListBinding
import com.example.studentappfragment.presentation.adapter.StudentAdapter
import com.example.studentappfragment.presentation.mvvm.StudentListViewModel
import com.example.studentappfragment.presentation.mvvm.StudentListViewModelFactory
import com.example.studentappfragment.presentation.navigator
import org.koin.androidx.viewmodel.ext.android.viewModel

class StudentListFragment : Fragment() {

    private lateinit var binding: FragmentStudentListBinding
    private lateinit var adapter: StudentAdapter

    private val viewModel: StudentListViewModel by viewModels {
        StudentListViewModelFactory(
            studentRepository = Di.listRepositoryImpl!!,
            storageImpl = Di.storageImpl
        )
    }

    //Вариант с Koin
    private val viewModelKoin: StudentListViewModel by viewModel<StudentListViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Di.context = requireContext()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentStudentListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
        observerListAdapter()
        initAddButton()
        initFieldSearch()
        viewModel.readStorage()
        observerFieldSearch()
    }

    //переход на StudentDetailsActivity по клику itemView в адаптере
    private fun initAdapter() {
        adapter = StudentAdapter(listenerDetails = {
            it.idStudent?.let { id ->
                navigator().navigationToDetailsStudent(id = id)
            }
        })
        binding.recyclerViewStudent.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerViewStudent.adapter = adapter
    }

    private fun observerListAdapter() {
        viewModel.allStudent.observe(viewLifecycleOwner) {
            adapter.listStudent = it
        }
        viewModel.list.observe(viewLifecycleOwner) {
            adapter.listStudent = it
        }
    }

    private fun initAddButton() {
        binding.btnAddStudentRecyclerView.setOnClickListener {
            navigator().navigationToCreateStudent()
        }
    }

    //Поиск студентов, сохранение и чтение сроки поиска
    private fun initFieldSearch() {
        binding.btnSearchStudent.setOnQueryTextListener(object : SearchView.OnQueryTextListener,
            android.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
                viewModel.saveStorage(name = newText)
                viewModel.searchVM(text = newText)
                return false
            }
        })
    }

    private fun observerFieldSearch() {
        viewModel.readSearch.observe(viewLifecycleOwner) {
            binding.btnSearchStudent.setQuery(it, false)
        }
    }

    companion object {

        @JvmStatic
        fun newInstance(): StudentListFragment {
            return StudentListFragment()
        }
    }

}