package com.example.project.presentation.di

import com.example.project.business.ProjectBusiness
import com.example.project.presentation.activity.MainActivity
import com.example.project.presentation.presenter.MainPresenter
import org.koin.dsl.module

val projectModule = module {

    single { ProjectBusiness() }

    single { MainActivity() }

    single { MainPresenter(get()) }
}