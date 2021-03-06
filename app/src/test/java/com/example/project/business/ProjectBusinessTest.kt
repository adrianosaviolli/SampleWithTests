package com.example.project.business

import com.example.project.presentation.di.projectModule
import junit.framework.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.koin.core.context.startKoin
import org.koin.test.AutoCloseKoinTest
import org.koin.test.inject

class ProjectBusinessTest : AutoCloseKoinTest() {

    private val business: ProjectBusiness by inject()

    @Before
    fun init() {
        startKoin {
            modules(projectModule)
        }
    }

    @Test
    fun calculate() {
        assertEquals(2.0, business.calculate(ProjectBusiness.SUM, 1.0, 1.0))
        assertEquals(1.0, business.calculate(ProjectBusiness.SUB, 2.0, 1.0))
        assertEquals(8.0, business.calculate(ProjectBusiness.MUL, 4.0, 2.0))
        assertEquals(2.0, business.calculate(ProjectBusiness.DIV, 4.0, 2.0))
    }

    @Test
    fun isValidInfo() {
        assertEquals(true, business.isValidInfo(1.0))
    }

    @Test
    fun isInvalidInfo() {
        assertEquals(false, business.isValidInfo(null))
    }
}