package com.example.project.presentation.presenter

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.project.LiveDataTestUtil
import com.example.project.business.ProjectBusiness
import com.example.project.presentation.di.projectModule
import junit.framework.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.koin.core.context.startKoin
import org.koin.test.AutoCloseKoinTest
import org.koin.test.inject

class MainPresenterTest : AutoCloseKoinTest() {

    @Rule
    @JvmField
    val instantExecutorRule = InstantTaskExecutorRule()

    lateinit var presenter : MainPresenter

    private val business: ProjectBusiness by inject()

    @Before
    fun init() {
        startKoin {
            modules(projectModule)
        }
        presenter = MainPresenter(business)
    }

    @Test
    fun `Teste com numerador nulo e denominador nulo`() {
        presenter.calculate(ProjectBusiness.SUM, null, null)
        assertNull(LiveDataTestUtil.getValue(presenter.handleLiveData()))
        assertNotNull(LiveDataTestUtil.getValue(presenter.handleLiveDataError()))
        assertNotNull(LiveDataTestUtil.getValue(presenter.handleLiveDataError()).consume())
    }

    @Test
    fun `Teste com numerador não nulo e denominador nulo`() {
        presenter.calculate(ProjectBusiness.SUM, 1.0, null)
        assertNull(LiveDataTestUtil.getValue(presenter.handleLiveData()))
        assertNotNull(LiveDataTestUtil.getValue(presenter.handleLiveDataError()))
        assertNotNull(LiveDataTestUtil.getValue(presenter.handleLiveDataError()).consume())
    }

    @Test
    fun `Teste com numerador nulo e denominador não nulo`() {
        presenter.calculate(ProjectBusiness.SUM, null, 1.0)
        assertNull(LiveDataTestUtil.getValue(presenter.handleLiveData()))
        assertNotNull(LiveDataTestUtil.getValue(presenter.handleLiveDataError()))
        assertNotNull(LiveDataTestUtil.getValue(presenter.handleLiveDataError()).consume())
    }

    @Test
    fun `Teste soma`() {
        presenter.calculate(ProjectBusiness.SUM, 1.0, 1.0)
        assertNotNull(LiveDataTestUtil.getValue(presenter.handleLiveData()))
        assertNotNull(LiveDataTestUtil.getValue(presenter.handleLiveData()).consume())
        assertEquals(2.0, LiveDataTestUtil.getValue(presenter.handleLiveData()).peek())
    }

    @Test
    fun `Teste subtracao`() {
        presenter.calculate(ProjectBusiness.SUB, 4.0, 1.0)
        assertNotNull(LiveDataTestUtil.getValue(presenter.handleLiveData()))
        assertNotNull(LiveDataTestUtil.getValue(presenter.handleLiveData()).consume())
        assertEquals(3.0, LiveDataTestUtil.getValue(presenter.handleLiveData()).peek())
    }

    @Test
    fun `Teste multiplicacao`() {
        presenter.calculate(ProjectBusiness.MUL, 3.0, 3.0)
        assertNotNull(LiveDataTestUtil.getValue(presenter.handleLiveData()))
        assertNotNull(LiveDataTestUtil.getValue(presenter.handleLiveData()).consume())
        assertEquals(9.0, LiveDataTestUtil.getValue(presenter.handleLiveData()).peek())
    }

    @Test
    fun `Teste divisao`() {
        presenter.calculate(ProjectBusiness.DIV, 6.0, 3.0)
        assertNotNull(LiveDataTestUtil.getValue(presenter.handleLiveData()))
        assertNotNull(LiveDataTestUtil.getValue(presenter.handleLiveData()).consume())
        assertEquals(2.0, LiveDataTestUtil.getValue(presenter.handleLiveData()).peek())
    }
}