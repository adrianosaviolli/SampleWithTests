package com.example.project.presentation.contract

import android.widget.EditText
import com.example.project.presentation.activity.MainActivity

interface MainContract {
    interface View {
        fun showResult(result: String)
        fun showError(error: String)
    }
    interface Presenter {
        fun calculate(view: MainActivity, operation: String, number1: EditText, number2: EditText)
    }
}