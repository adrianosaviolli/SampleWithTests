package com.example.project.presentation.contract

interface MainContract {

    interface Presenter {
        fun calculate(operation: String, number1: Double?, number2: Double?)
    }
}