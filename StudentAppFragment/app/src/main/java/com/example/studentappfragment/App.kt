package com.example.studentappfragment

import android.app.Application
import com.example.studentappfragment.data.di.dataModule
import com.example.studentappfragment.data.di.presentationModule
import com.example.studentappfragment.data.di.roomModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin
import org.koin.core.logger.Level

class App : Application() {

    //Вариант с Koin
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(applicationContext)
            modules(
                presentationModule,
                roomModule,
                dataModule
            )
        }
    }


}