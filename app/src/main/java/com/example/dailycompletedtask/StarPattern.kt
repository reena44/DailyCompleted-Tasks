package com.example.dailycompletedtask

import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_star_pattern.*

class StarPattern:AppCompatActivity() {
    private var temp = " "

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_star_pattern)
        btn_print_pattern.setOnClickListener {
            if (TextUtils.isEmpty(edt_number.text.toString())) {
                Toast.makeText(this, getString(R.string.empty_number_field), Toast.LENGTH_LONG).show()
            } else {
                printStarPattern((edt_number.text.toString()).toInt())
            }

        }
    }

    private fun printStarPattern(value: Int) {
        var star = " "
        for (row in 0 until value) {
            for (space in value - row downTo 1) {
                println(space)
                star +=  "  "
            }
            for (colu in 0..row*2) {
                star += "* "
            }
            star += "\n"
        }
       tv_star.text = star
    }
}