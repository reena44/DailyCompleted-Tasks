package com.example.dailycompletedtask

import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class PalindromeNumber : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_submit.setOnClickListener {
            if (TextUtils.isEmpty(edt_number.text.toString())) {
                Toast.makeText(this, getString(R.string.empty_number_field), Toast.LENGTH_LONG).show()
            } else {
                testPalindromeNum((edt_number.text.toString()).toInt())
            }
        }
    }

    private fun testPalindromeNum(number: Int) {
      var sum = 0
        var temp = number
        while (temp > 0) {
            val reminder = temp % 10
            sum = (sum * 10) + reminder
            temp /= 10
        }
        if (number == sum)
            tv_result.text = getString(R.string.valid_palindrome_num).plus(":").plus(number)
        else
            tv_result.text = getString(R.string.not_valid_palindrome_num).plus(":").plus(number)
    }
}