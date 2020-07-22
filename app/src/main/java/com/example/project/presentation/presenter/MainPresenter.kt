package com.example.project.presentation.presenter

import android.widget.EditText
import com.example.project.business.ProjectBusiness
import com.example.project.presentation.activity.MainActivity
import com.example.project.presentation.contract.MainContract

class MainPresenter(private val business: ProjectBusiness) : MainContract.Presenter {

    override fun calculate(view: MainActivity, operation: String, number1: EditText, number2: EditText) {
        if (business.isValidInfo(number1.text?.toString()) && business.isValidInfo(number2.text?.toString())) {
            val result = business.calculate(operation,
                number1.text.toString().toDouble(),
                number2.text.toString().toDouble()
            ).toString()

            view.showResult(result)
        } else {
            view.showError("Erro, campos em branco")
        }



    }
}