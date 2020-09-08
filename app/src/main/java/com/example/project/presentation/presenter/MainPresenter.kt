package com.example.project.presentation.presenter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.project.business.ProjectBusiness
import com.example.project.event.Event
import com.example.project.presentation.contract.MainContract

class MainPresenter(private val business: ProjectBusiness) : MainContract.Presenter {

    private var _handleLiveData : MutableLiveData<Event<Double>> = MutableLiveData()

    private var _handleLiveDataError : MutableLiveData<Event<Double>> = MutableLiveData()

    override fun calculate(operation: String, number1: Double?, number2: Double?) {
        if (business.isValidInfo(number1) && business.isValidInfo(number2)) {
            val result = business.calculate(operation, number1!!, number2!!)
            _handleLiveData.postValue(Event(result))
        } else {
            _handleLiveDataError.postValue(Event(1.0))
        }
    }

    fun handleLiveData() : LiveData<Event<Double>> {
        return _handleLiveData
    }

    fun handleLiveDataError() : LiveData<Event<Double>> {
        return _handleLiveDataError
    }
}