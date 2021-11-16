package com.example.lesson3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.lesson3.databinding.FragmentFirstBinding

class FragmentFirst: Fragment() {

    private val dataModel: DataModel by activityViewModels()
    lateinit var binding: FragmentFirstBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstBinding.inflate(inflater)
        if(dataModel.firstNumber.value != null) {
            binding.number1.setText(dataModel.firstNumber.value.toString())
        }
        val mainActivity = (activity as MainActivity?)!!
        mainActivity.binding.button2.visibility = View.GONE
        mainActivity.binding.button3.visibility = View.GONE
        mainActivity.binding.button4.visibility = View.GONE
        mainActivity.binding.buttonNext.visibility = View.VISIBLE
        mainActivity.binding.buttonBack.visibility = View.GONE
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        dataModel.firstNumber.value = binding.number1.text.toString()
    }
}