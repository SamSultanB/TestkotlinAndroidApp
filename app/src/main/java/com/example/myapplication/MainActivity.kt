package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.RadioButton
import com.example.myapplication.databinding.ActivityMainBinding
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.calculateButton.setOnClickListener {
            calculateTip()
        }
    }

    fun calculateTip(){
        val stringInTextField = binding.something.text.toString()
        val cost = stringInTextField.toDouble()
        val selected = binding.options.checkedRadioButtonId
        val percentage = when(selected){
            R.id.twenty -> 0.20
            R.id.fifty -> 0.50
            else -> 0.30
        }

        var tip = cost * percentage

        val roundUp = binding.rounder.isChecked

        if(roundUp){
            tip = kotlin.math.ceil(tip)
        }

        val formattedTip = NumberFormat.getCurrencyInstance().format(tip)

        Log.d("Sula", "calculateTip: $formattedTip")
        binding.tipAmount.text = getString(R.string.TipAmount, formattedTip)

    }

}