package com.example.lesson3

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class NumberModel: ViewModel() {
    val firstNumber: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
    val secondNumber: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
    val action: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
}