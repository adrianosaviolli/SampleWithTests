package com.example.project.presentation.di

import com.example.project.business.ProjectBusiness
import com.example.project.repository.UserRepository
import org.koin.dsl.module

val projectModule = module {
    single { ProjectBusiness() }
    single { UserRepository() }
}