package com.example.project.presentation.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.project.R
import com.example.project.business.ProjectBusiness
import com.example.project.event.Event
import com.example.project.presentation.presenter.MainPresenter
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    private val presenter : MainPresenter by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_sum.setOnClickListener {
            presenter.calculate(ProjectBusiness.SUM, edt_number1.editableText.toString().toDoubleOrNull(), edt_number2.editableText.toString().toDoubleOrNull())
        }

        btn_subtract.setOnClickListener {
            presenter.calculate(ProjectBusiness.SUB, edt_number1.editableText.toString().toDoubleOrNull(), edt_number2.editableText.toString().toDoubleOrNull())
        }

        btn_multiplication.setOnClickListener {
            presenter.calculate(ProjectBusiness.MUL, edt_number1.editableText.toString().toDoubleOrNull(), edt_number2.editableText.toString().toDoubleOrNull())
        }

        btn_division.setOnClickListener {
            presenter.calculate(ProjectBusiness.DIV, edt_number1.editableText.toString().toDoubleOrNull(), edt_number2.editableText.toString().toDoubleOrNull())
        }

        presenter.handleLiveData().observe(this, Observer<Event<Double>> {
            if (it.consume() != null) {
                showResult(it.peek())
            }
        })

        presenter.handleLiveDataError().observe(this, Observer<Event<Double>> {
            if (it.consume() != null) {
                it.peek()
                showError(getString(R.string.error))
            }
        })
    }

    private fun showResult(result: Double) {
        tv_result.text = result.toString()
    }

    private fun showError(error: String) {
        tv_result.text = error
    }
}