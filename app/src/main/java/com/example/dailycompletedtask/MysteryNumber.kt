package com.example.dailycompletedtask

import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MysteryNumber : AppCompatActivity() {
    var reverse = 0
    var flag = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mystery_number)
        btn_submit.setOnClickListener {
            if (TextUtils.isEmpty(edt_number.text.toString())) {
                Toast.makeText(this, getString(R.string.empty_number_field), Toast.LENGTH_LONG).show()
            } else {
                checkMysteryNum((edt_number.text.toString()).toInt())
            }
        }
    }

    private fun checkMysteryNum(number: Int) {
        tv_result.text = " "

        for (i in 1..number / 2) {
            reverse = reverseList(i.toString())
            if (reverse + i == number) {
                flag = true
                tv_result.text = "$number ".plus(getString(R.string.valid_mystery_number))
                break
            }
        }
        if (!flag)
            tv_result.text = "$number ".plus(getString(R.string.not_valid_mystery_number))
    }

    private fun reverseList(string: String): Int {
        val listOfString = (string.split(""))
        var reverseValue = ""
        for (a in listOfString.asReversed()) {
            reverseValue += a
        }
        return reverseValue.toInt()
    }
}
