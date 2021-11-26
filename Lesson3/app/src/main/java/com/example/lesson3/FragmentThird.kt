package com.example.lesson3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.lesson3.databinding.FragmentThirdBinding


class FragmentThird: Fragment() {

    private val numberModel: NumberModel by activityViewModels()
    private  lateinit var binding: FragmentThirdBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentThirdBinding.inflate(inflater)
        binding.plus.setOnClickListener {
            numberModel.action.value = "+"
            openFragmentFour()
        }
        binding.minus.setOnClickListener {
            numberModel.action.value = "-"
            openFragmentFour()
        }
        binding.multiplication.setOnClickListener {
            numberModel.action.value = "*"
            openFragmentFour()
        }
        binding.division.setOnClickListener {
            numberModel.action.value = "/"
            openFragmentFour()
        }
        val mainActivity = (activity as MainActivity?)!!
        mainActivity.binding.button2.visibility = View.VISIBLE
        mainActivity.binding.button3.visibility = View.VISIBLE
        mainActivity.binding.button4.visibility = View.GONE
        mainActivity.binding.buttonNext.visibility = View.GONE
        mainActivity.binding.buttonBack.visibility = View.VISIBLE
        return binding.root
    }

    private fun openFragmentFour() {
        var fr = parentFragmentManager?.beginTransaction()
        fr?.replace(R.id.container, FragmentFour())
        fr?.addToBackStack("4")
        fr?.commit()
    }

}