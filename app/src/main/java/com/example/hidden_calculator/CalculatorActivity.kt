package com.example.hidden_calculator

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class CalculatorActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var firstOperandET: EditText
    private lateinit var secondOperandET: EditText

    private lateinit var sumBTN: Button
    private lateinit var subBTN: Button
    private lateinit var multBTN: Button
    private lateinit var divBTN: Button
    private lateinit var resultBTN: Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_calculator)

        firstOperandET = findViewById(R.id.firstOperandET)
        secondOperandET = findViewById(R.id.secondOperandET)

        sumBTN = findViewById(R.id.sumBTN)
        subBTN = findViewById(R.id.subBTN)
        multBTN = findViewById(R.id.multBTN)
        divBTN = findViewById(R.id.divBTN)
        resultBTN = findViewById(R.id.resultBTN)

        sumBTN.setOnClickListener(this)
        subBTN.setOnClickListener(this)
        multBTN.setOnClickListener(this)
        divBTN.setOnClickListener(this)
        resultBTN.setOnClickListener(this)


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


    }

    override fun onClick(v: View) {
        if (firstOperandET.text.isEmpty() || secondOperandET.text.isEmpty()) return

        val first = firstOperandET.text.toString().toDouble()
        val second = secondOperandET.text.toString().toDouble()
        

        val result = when (v.id) {
            R.id.sumBTN -> first + second
            R.id.subBTN -> first - second
            R.id.multBTN -> first * second
            R.id.divBTN -> first / second
            else -> 0.0
        }

        resultBTN.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("key", result.toString())
            startActivity(intent)
        }

    }

}