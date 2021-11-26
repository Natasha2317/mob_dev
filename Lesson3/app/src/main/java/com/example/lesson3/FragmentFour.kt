package com.example.lesson3

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.lesson3.databinding.FragmentFourBinding

class FragmentFour: Fragment() {
    private val numberModel: NumberModel by activityViewModels()
    private lateinit var binding: FragmentFourBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFourBinding.inflate(inflater)
        val mainActivity = (activity as MainActivity?)!!
        mainActivity.binding.button2.visibility = View.VISIBLE
        mainActivity.binding.button3.visibility = View.VISIBLE
        mainActivity.binding.button4.visibility = View.VISIBLE
        mainActivity.binding.buttonNext.visibility = View.GONE
        mainActivity.binding.buttonBack.visibility = View.VISIBLE
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        var result: Double = 0.0
        super.onViewCreated(view, savedInstanceState)
        if(numberModel.action.value.toString() == "+" && numberModel.firstNumber.value.toString() != "" && numberModel.secondNumber.value.toString() != "") {
            result = numberModel.firstNumber.value!!.toDouble() + numberModel.secondNumber.value!!.toDouble()
        }
        if(numberModel.action.value.toString() == "-" && numberModel.firstNumber.value.toString() != "" && numberModel.secondNumber.value.toString() != "") {
            result = numberModel.firstNumber.value!!.toDouble() - numberModel.secondNumber.value!!.toDouble()
        }
        if(numberModel.action.value.toString() == "*" && numberModel.firstNumber.value.toString() != "" && numberModel.secondNumber.value.toString() != "") {
            result = numberModel.firstNumber.value!!.toDouble() * numberModel.secondNumber.value!!.toDouble()
        }
        if(numberModel.action.value.toString() == "/" && numberModel.firstNumber.value.toString() != "" && numberModel.secondNumber.value.toString() != "") {
            result = numberModel.firstNumber.value!!.toDouble() / numberModel.secondNumber.value!!.toDouble()
        }
        binding.result.text = result.toString()
    }
}