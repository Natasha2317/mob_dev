package com.example.lesson3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.lesson3.databinding.ActivityMainBinding


class MainActivity: AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fragment = FragmentFirst()
        val transaction = supportFragmentManager
            .beginTransaction()
            .replace(R.id.container, fragment)
        transaction.commit()


        binding.button1.setOnClickListener {
            replaceFragment(FragmentFirst(),"1")
        }
        binding.button2.setOnClickListener {
            replaceFragment(FragmentSecond(), "2")
        }
        binding.button3.setOnClickListener {
            replaceFragment(FragmentThird(),"3")
        }
        binding.button4.setOnClickListener {
            replaceFragment(FragmentFour(),"4")
        }

        binding.buttonNext.setOnClickListener {
            if (supportFragmentManager.fragments.last() is FragmentFirst) {
                replaceFragment(FragmentSecond(), "2")
            }
            if (supportFragmentManager.fragments.last() is FragmentSecond) {
                replaceFragment(FragmentThird(), "3")
            }
            if (supportFragmentManager.fragments.last() is FragmentThird) {
                replaceFragment(FragmentFour(), "4")
            }

        }

        binding.buttonBack.setOnClickListener {
            supportFragmentManager.popBackStack()
        }

    }

    private fun replaceFragment(fragment: Fragment, tag:String) {
        val transaction = supportFragmentManager
            .beginTransaction()
            .replace(R.id.container, fragment)
            .addToBackStack(tag)
        transaction.commit()
    }
}


