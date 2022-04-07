package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import androidx.fragment.app.Fragment


class MainActivity : AppCompatActivity(R.layout.activity_main) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        addFragment(CalculatorFragment())
    }
    fun addFragment(fragment: Fragment){
        supportFragmentManager
            .beginTransaction()
            .add(R.id.container, fragment)
            //.addToBackStack(null)
            .commit()
    }
}

fun Fragment.pushFragment(counter : Int){
    (requireActivity() as MainActivity)
        .addFragment(CalculatorFragment.getInstance(counter))
}