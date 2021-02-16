package com.example.dailycompletedtask

import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class ArmstrongNumber:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mystery_number)
        title = "Armstrong Numbers"
        tv_result.text = ""

        btn_submit.setOnClickListener {
            if (TextUtils.isEmpty(edt_number.text.toString())) {
                Toast.makeText(this, getString(R.string.empty_number_field), Toast.LENGTH_LONG)
                    .show()
            } else {
                val number = edt_number.text.toString().toInt()
                val value = checkArmstrongNumber(number)
                if (number == value) {
                    tv_result.text = "$number ".plus(getString(R.string.valid_armstrong))
                } else {
                    tv_result.text = "$number ".plus(getString(R.string.invalid_armstrong))

                }
            }
        }
    }

    private fun checkArmstrongNumber(number: Int): Int {
        var result = 0
        var n = number
        var reminder = 0

        when (number) {
            0 -> {
                return 0
            }
            1 -> {
                return 1
            }
            else -> {
                while ( n > 0) {
                   reminder = n % 10
                    n /= 10
                    result += (reminder * reminder * reminder)
                }
                return result

            }
        }

    }
}