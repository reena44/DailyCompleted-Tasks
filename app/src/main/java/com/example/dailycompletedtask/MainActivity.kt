package com.example.dailycompletedtask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_submit.setOnClickListener {
            if (TextUtils.isEmpty(edt_number.text.toString())) {
                Toast.makeText(this, getString(R.string.empty_number_field), Toast.LENGTH_LONG).show()
            } else {
                fibonacciSeries(edt_number.text.toString())
            }
        }
    }

    private fun fibonacciSeries(number: String) {
        var num1= 0
        var num2= 1
        when {
            number.toInt() == 0 -> {
                tv_result.text= number
            }
            number.toInt() == 1 -> {
                tv_result.text= number
            }
            else -> {
                tv_result.text = " "


                for (i in 0 until number.toInt()) {
                    if (i == 0) {
                        tv_result.append("$num1 ")

                    } else if (i == 1){
                        tv_result.append("$num2 ")
                    }

                    val sum = num1 + num2
                    tv_result.append("$sum ")
                    num1 = num2
                    num2 = sum
                }
            }
        }
    }

}