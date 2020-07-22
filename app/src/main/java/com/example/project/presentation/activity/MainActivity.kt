package com.example.project.presentation.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.project.R
import com.example.project.business.ProjectBusiness
import com.example.project.presentation.contract.MainContract
import com.example.project.presentation.presenter.MainPresenter
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity(), MainContract.View {

    private val presenter : MainPresenter by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_sum.setOnClickListener {
            presenter.calculate(this, ProjectBusiness.SUM, edt_number1, edt_number2)
        }

        btn_subtract.setOnClickListener {
            presenter.calculate(this, ProjectBusiness.SUBTRACT, edt_number1, edt_number2)
        }

        btn_multiplication.setOnClickListener {
            presenter.calculate(this, ProjectBusiness.MULT, edt_number1, edt_number2)
        }

        btn_division.setOnClickListener {
            presenter.calculate(this, ProjectBusiness.DIVIDE, edt_number1, edt_number2)
        }
    }

    override fun showResult(result: String) {
        tv_result.text = result
    }

    override fun showError(error: String) {
        tv_result.text = error
    }
}