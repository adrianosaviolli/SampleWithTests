package com.example.project.presentation.activity

import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.project.R
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotNull
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.koin.test.AutoCloseKoinTest
import org.mockito.MockitoAnnotations
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [28])
class MainActivityTest : AutoCloseKoinTest() {

    private var view : MainActivity? = null
    private var btnSum : Button? = null
    private var btnSub : Button? = null
    private var edt1 : EditText? = null
    private var edt2 : EditText? = null
    private var tvResult : TextView? = null
    private var btnMult: Button? = null
    private var btnDiv: Button? = null

    @Before
    fun init() {
        MockitoAnnotations.initMocks(this)

        view = Robolectric.buildActivity(MainActivity::class.java)
            .setup()
            .get()

        btnSum = view?.findViewById(R.id.btn_sum) as Button
        btnSub = view?.findViewById(R.id.btn_subtract) as Button
        btnMult = view?.findViewById(R.id.btn_multiplication) as Button
        btnDiv = view?.findViewById(R.id.btn_division) as Button
        edt1 = view?.findViewById(R.id.edt_number1) as EditText
        edt2 = view?.findViewById(R.id.edt_number2) as EditText
        tvResult = view?.findViewById(R.id.tv_result) as TextView
    }

    @Test
    fun testActivityIsNotNull() {
        assertNotNull(view)
    }

    @Test
    fun testVisibilityFields() {
        assertEquals(View.VISIBLE, btnSum?.visibility)
        assertEquals(View.VISIBLE, btnSub?.visibility)
        assertEquals(View.VISIBLE, edt1?.visibility)
        assertEquals(View.VISIBLE, edt2?.visibility)
        assertEquals(View.VISIBLE, tvResult?.visibility)
        assertEquals(View.VISIBLE, btnMult?.visibility)
        assertEquals(View.VISIBLE, btnDiv?.visibility)

    }

    @Test
    fun testSum() {
        edt1?.setText("10")
        edt2?.setText("10")

        btnSum?.performClick()

        assertEquals("20.0", tvResult?.text)
    }

    @Test
    fun testSub() {
        edt1?.setText("10")
        edt2?.setText("10")

        btnSub?.performClick()

        assertEquals("0.0", tvResult?.text)

    }

    @Test
    fun testMult() {
        edt1?.setText("10")
        edt2?.setText("23")

        btnMult?.performClick()

        assertEquals("230.0", tvResult?.text)
    }

    @Test
    fun testDiv() {
        edt1?.setText("10")
        edt2?.setText("2")

        btnDiv?.performClick()

        assertEquals("5.0",tvResult?.text)
    }
}