package com.example.lesson3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.lesson3.databinding.FragmentSecondBinding

class FragmentSecond: Fragment() {

    private val numberModel: NumberModel by activityViewModels()
    lateinit var binding: FragmentSecondBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSecondBinding.inflate(inflater)
        if(numberModel.secondNumber.value != null) {
            binding.number2.setText(numberModel.secondNumber.value.toString())
        }
        val mainActivity = (activity as MainActivity?)!!
        mainActivity.binding.button1.visibility = View.VISIBLE
        mainActivity.binding.button2.visibility = View.VISIBLE
        mainActivity.binding.button3.visibility = View.GONE
        mainActivity.binding.button4.visibility = View.GONE
        mainActivity.binding.buttonBack.visibility = View.VISIBLE
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        numberModel.secondNumber.value = binding.number2.text.toString()
    }
}