package com.example.project

import android.app.Application
import com.example.project.presentation.di.projectModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class ProjectApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@ProjectApplication)
            modules(projectModule)
        }
    }
}