package com.example.studentappfragment.data.di

import android.annotation.SuppressLint
import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import com.example.studentappfragment.data.db.MainDataBase
import com.example.studentappfragment.data.repository.Storage
import com.example.studentappfragment.data.repository.StorageImpl
import com.example.studentappfragment.data.repository.StudentRepository
import com.example.studentappfragment.data.repository.StudentRepositoryImpl
import com.example.studentappfragment.presentation.mvvm.StudentDetailsViewModel
import com.example.studentappfragment.presentation.mvvm.StudentEditViewModel
import com.example.studentappfragment.presentation.mvvm.StudentListViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

@SuppressLint("StaticFieldLeak")
object Di {

    var context: Context? = null

    val listRepositoryImpl by lazy {
        daoStudent?.let { StudentRepositoryImpl(dao = it) }
    }

    val storageImpl by lazy {
        StorageImpl(context = context!!)
    }

    private val mainDataBase by lazy {
        context?.let { MainDataBase.mainDataBase(context = it) }
    }

    private val daoStudent by lazy {
        mainDataBase?.dao()
    }
}

// Вариант с Koin
val presentationModule = module {

    viewModel { StudentListViewModel(studentRepository = get(), storageImpl = get()) }

    viewModel { StudentDetailsViewModel(studentRepository = get()) }

    viewModel { StudentEditViewModel(studentRepository = get()) }

}

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "student_app_fragment")

val dataModule = module {

    single<StudentRepository> { StudentRepositoryImpl(dao = get()) }

    single<Storage> { StorageImpl(context = get()) }

    single { get<Context>().dataStore }

}

val roomModule = module {
    single {
        MainDataBase.mainDataBase(context = androidContext().applicationContext).dao()
    }
}
