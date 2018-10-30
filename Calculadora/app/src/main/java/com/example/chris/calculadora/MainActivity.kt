package com.example.chris.calculadora

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Numeros
        btn1.setOnClickListener { appendOnExpresstion("1", true) }
        btn2.setOnClickListener { appendOnExpresstion("2", true) }
        btn3.setOnClickListener { appendOnExpresstion("3", true) }
        btn4.setOnClickListener { appendOnExpresstion("4", true) }
        btn5.setOnClickListener { appendOnExpresstion("5", true) }
        btn6.setOnClickListener { appendOnExpresstion("6", true) }
        btn7.setOnClickListener { appendOnExpresstion("7", true) }
        btn8.setOnClickListener { appendOnExpresstion("8", true) }
        btn9.setOnClickListener { appendOnExpresstion("9", true) }
        btn0.setOnClickListener { appendOnExpresstion("0", true) }
        btnpunto.setOnClickListener { appendOnExpresstion(".", true) }

        //Operandos
        btnsuma.setOnClickListener { appendOnExpresstion("+", false) }
        btnres.setOnClickListener { appendOnExpresstion("-", false) }
        btnmul.setOnClickListener { appendOnExpresstion("*", false) }
        btndiv.setOnClickListener { appendOnExpresstion("/", false) }

        btnigual.setOnClickListener {
            try {
                val expression = ExpressionBuilder(tvExpresion.text.toString()).build()
                val result = expression.evaluate()
                val longResult = result.toLong()
                if(result == longResult.toDouble())
                    tvResult.text = longResult.toString()
                else
                    tvResult.text = result.toString()
            }catch (e:Exception){
                Log.d("Exception"," message : " + e.message )
            }
        }
    }

    private fun appendOnExpresstion(string: String, canClear: Boolean) {
        if (tvResult.text.isNotEmpty()) {
            tvExpresion.text = ""
        }

        if (canClear) {
            tvResult.text = ""
            tvExpresion.append(string)
        } else {
            tvExpresion.append(tvResult.text)
            tvExpresion.append(string)
            tvResult.text = ""
        }
    }


}

