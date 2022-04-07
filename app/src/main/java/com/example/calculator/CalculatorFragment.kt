package com.example.calculator

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.example.calculator.databinding.FragmentCalculatorBinding
import kotlin.math.max

class CalculatorFragment(): Fragment(){

    private var _binding: FragmentCalculatorBinding? = null
    private val binding get() = requireNotNull(_binding) {"View was destroyed"}

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentCalculatorBinding.inflate(inflater, container, false)
            .also { _binding = it }
            .root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var s = "0"
        val ops = "+-*/"
        var firstValue = 0.0
        var secondValue = 0.0
        var result = 0.0
        var opSymbol = ""
        with (binding){
            outText.text = s
            //Числа
            button0.setOnClickListener {
                if(s.contains('.') || s[0] != '0'){
                    s += "0"
                    outText.text = s
                }else{
                    outText.text = s
                }
            }
            button1.setOnClickListener {
                if(s[0] == '0' && s.length == 1) {
                    s = "1"
                    outText.text = s
                }else if (s[0] == '-' && s[1] == '0'){
                    s = "-1"
                    outText.text = s
                }else{
                    s += "1"
                    outText.text = s
                }
            }
            button2.setOnClickListener {
                if(s[0] == '0' && s.length == 1) {
                    s = "2"
                    outText.text = s
                }else if (s[0] == '-' && s[1] == '0'){
                    s = "-2"
                    outText.text = s
                }else{
                    s += "2"
                    outText.text = s
                }
            }
            button3.setOnClickListener {
                if(s[0] == '0' && s.length == 1) {
                    s = "3"
                    outText.text = s
                }else if (s[0] == '-' && s[1] == '0'){
                    s = "-3"
                    outText.text = s
                }else{
                    s += "3"
                    outText.text = s
                }
            }
            button4.setOnClickListener {
                if(s[0] == '0' && s.length == 1) {
                    s = "4"
                    outText.text = s
                }else if (s[0] == '-' && s[1] == '0'){
                    s = "-4"
                    outText.text = s
                }else{
                    s += "4"
                    outText.text = s
                }
            }
            button5.setOnClickListener {
                if(s[0] == '0' && s.length == 1) {
                    s = "5"
                    outText.text = s
                }else if (s[0] == '-' && s[1] == '0'){
                    s = "-5"
                    outText.text = s
                }else{
                    s += "5"
                    outText.text = s
                }
            }
            button6.setOnClickListener {
                if(s[0] == '0' && s.length == 1) {
                    s = "6"
                    outText.text = s
                }else if (s[0] == '-' && s[1] == '0'){
                    s = "-6"
                    outText.text = s
                }else{
                    s += "6"
                    outText.text = s
                }
            }
            button7.setOnClickListener {
                if(s[0] == '0' && s.length == 1) {
                    s = "7"
                    outText.text = s
                }else if (s[0] == '-' && s[1] == '0'){
                    s = "-7"
                    outText.text = s
                }else{
                    s += "7"
                    outText.text = s
                }
            }
            button8.setOnClickListener {
                if(s[0] == '0' && s.length == 1) {
                    s = "8"
                    outText.text = s
                }else if (s[0] == '-' && s[1] == '0'){
                    s = "-8"
                    outText.text = s
                }else{
                    s += "8"
                    outText.text = s
                }
            }
            button9.setOnClickListener {
                if(s[0] == '0' && s.length == 1) {
                    s = "9"
                    outText.text = s
                }else if (s[0] == '-' && s[1] == '0'){
                    s = "-9"
                    outText.text = s
                }else{
                    s += "9"
                    outText.text = s
                }
            }
            buttonDot.setOnClickListener {
                if(s.isNotEmpty() && ops.contains(s.last())) s += "0"
                var lst = 0
                lst = max(lst, s.lastIndexOfAny(ops.toCharArray()))
                if (!s.substring(lst, s.length).contains('.')) s += "."
                outText.text = s
            }

            //Операторы
            buttonAC.setOnClickListener {
                s = "0"
                result = 0.0
                firstValue = 0.0
                secondValue = 0.0
                outText.text = s
            }

            buttonPlusMinus.setOnClickListener {
                if(s.first() == '-'){
                    s = s.removePrefix("-")
                    outText.text = s
                }else{
                    s ="-$s"
                    outText.text = s
                }
            }

            buttonSum.setOnClickListener {
                if(firstValue == 0.0){
                    firstValue = s.toDouble()
                    outText.text = "+"
                    s = "0"
                    opSymbol = "+"
                }else if (firstValue == result && s == "0"){
                    secondValue = 0.0
                    opSymbol = "+"
                    result = doOperation(opSymbol, firstValue, secondValue)
                    firstValue = result
                    s = "0"
                    outText.text = "+"
                }else{
                    secondValue = s.toDouble()
                    result = doOperation(opSymbol, firstValue, secondValue)
                    firstValue = result
                    opSymbol = "+"
                    s = "0"
                    outText.text = "+"
                }
            }

            buttonSubtract.setOnClickListener {
                if(firstValue == 0.0){
                    firstValue = s.toDouble()
                    outText.text = "-"
                    s = "0"
                    opSymbol = "-"
                }else if (firstValue == result && s == "0"){
                    secondValue = 0.0
                    opSymbol = "-"
                    result = doOperation(opSymbol, firstValue, secondValue)
                    firstValue = result
                    s = "0"
                    outText.text = "-"
                }else{
                    secondValue = s.toDouble()
                    result = doOperation(opSymbol, firstValue, secondValue)
                    firstValue = result
                    s = "0"
                    opSymbol = "-"
                    outText.text = "-"
                }
            }

            buttonMultiply.setOnClickListener {
                if(firstValue == 0.0){
                    firstValue = s.toDouble()
                    outText.text = "*"
                    s = "0"
                    opSymbol = "*"
                }else if (firstValue == result && s == "0"){
                    secondValue = 1.0
                    opSymbol = "*"
                    result = doOperation(opSymbol, firstValue, secondValue)
                    firstValue = result
                    s = "0"
                    outText.text = "*"
                }else{
                    secondValue = s.toDouble()
                    result = doOperation(opSymbol, firstValue, secondValue)
                    firstValue = result
                    s = "0"
                    opSymbol = "*"
                    outText.text = "*"
                }
            }

            buttonDivide.setOnClickListener {
                if(firstValue == 0.0 && secondValue == 0.0){
                    firstValue = s.toDouble()
                    outText.text = "/"
                    s = "0"
                    opSymbol = "/"
                }else if (firstValue == result && s == "0"){
                    secondValue = 1.0
                    opSymbol = "/"
                    result = doOperation(opSymbol, firstValue, secondValue)
                    firstValue = result
                    s = "0"
                    outText.text = "/"
                }else{
                    secondValue = s.toDouble()
                    result = doOperation(opSymbol, firstValue, secondValue)
                    firstValue = result
                    s = "0"
                    opSymbol = "/"
                    outText.text = "/"
                }
            }
            buttonEquals.setOnClickListener {
                if(s == "0" && opSymbol == "/"){
                    secondValue = 1.0
                    result = doOperation(opSymbol, firstValue, secondValue)
                    firstValue = result
                    s = "0"
                    outText.text = result.toString()
                }else if(s == "0" && opSymbol == "*"){
                    secondValue = 1.0
                    result = doOperation(opSymbol, firstValue, secondValue)
                    firstValue = result
                    s = "0"
                    outText.text = result.toString()
                }else{
                    secondValue = s.toDouble()
                    result = doOperation(opSymbol, firstValue, secondValue)
                    firstValue = result
                    s = "0"
                    outText.text = result.toString()
                }

            }
        }
    }
    private fun doOperation(opSymbol: String = "", left: Double, right: Double) : Double {
        when (opSymbol) {
            "+" -> return left + right
            "-" -> return left - right
            "*" -> return left * right
            "/" -> return left / right
        }

        return opSymbol.toDouble()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    companion object {
        private  const val KEY_COUNTER = "key_counter"
        fun getInstance(counter : Int): CalculatorFragment{
            return CalculatorFragment().apply {
                arguments = bundleOf(KEY_COUNTER to counter)
            }
        }
    }
}