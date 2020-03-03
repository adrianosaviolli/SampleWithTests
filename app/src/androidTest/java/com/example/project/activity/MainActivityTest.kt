package com.example.project.activity

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import com.example.project.R
import com.example.project.presentation.activity.MainActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
@LargeTest
class MainActivityTest {

    @get:Rule
    var activityRule: ActivityTestRule<MainActivity> = ActivityTestRule(MainActivity::class.java)

    @Test
    fun testVisibility() {
        onView(withId(R.id.edt_number1))
            .check(matches(isDisplayed()))

        onView(withId(R.id.edt_number2))
            .check(matches(isDisplayed()))

        onView(withId(R.id.nested_scrollview))
            .perform(swipeUp())

        onView(withId(R.id.btn_sum))
            .check(matches(isDisplayed()))

        onView(withId(R.id.btn_subtract))
            .check(matches(isDisplayed()))

        onView(withId(R.id.btn_division))
            .check(matches(isDisplayed()))

        onView(withId(R.id.btn_multiplication))
            .check(matches(isDisplayed()))
    }

    @Test
    fun testInvalidSum() {
        onView(withId(R.id.edt_number1))
            .perform(typeText(""), closeSoftKeyboard())

        onView(withId(R.id.btn_sum))
            .perform(click())

        onView(withId(R.id.tv_result))
            .check(matches(withText("Erro, campos em branco")))
    }

    @Test
    fun testSum() {
        onView(withId(R.id.edt_number1))
            .perform(typeText("1"), closeSoftKeyboard())

        onView(withId(R.id.edt_number2))
            .perform(typeText("1"), closeSoftKeyboard())

        onView(withId(R.id.btn_sum))
            .perform(click())

        onView(withId(R.id.tv_result))
            .check(matches(withText("2.0")))
    }

    @Test
    fun testSub() {
        onView(withId(R.id.edt_number1))
            .perform(typeText("2"), closeSoftKeyboard())

        onView(withId(R.id.edt_number2))
            .perform(typeText("1"), closeSoftKeyboard())

        onView(withId(R.id.btn_subtract))
            .perform(click())

        onView(withId(R.id.tv_result))
            .check(matches(withText("1.0")))
    }

    @Test
    fun testMult(){
        onView(withId(R.id.edt_number1))
            .perform(typeText("5"), closeSoftKeyboard())

        onView(withId(R.id.edt_number2))
            .perform(typeText("5"), closeSoftKeyboard())

        onView(withId(R.id.btn_multiplication))
            .perform(scrollTo())
            .check(matches(isDisplayed()))

        onView(withId(R.id.btn_multiplication))
            .perform(click())

        onView(withId(R.id.tv_result))
            .check(matches(withText("25.0")))
    }

    @Test
    fun testDiv(){
        onView(withId(R.id.edt_number1))
            .perform(typeText("10"), closeSoftKeyboard())

        onView(withId(R.id.edt_number2))
            .perform(typeText("2"), closeSoftKeyboard())

        onView(withId(R.id.btn_division))
            .perform(scrollTo())
            .check(matches(isDisplayed()))

        onView(withId(R.id.btn_division))
            .perform(click())

        onView(withId(R.id.tv_result))
            .check(matches(withText("5.0")))
    }
}