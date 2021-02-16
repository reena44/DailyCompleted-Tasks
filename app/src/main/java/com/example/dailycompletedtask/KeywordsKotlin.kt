package com.example.dailycompletedtask

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class KeywordsKotlin: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mystery_number)
        var number = 1
        var num = number.let { it + 10  }
        println(" let resultHere $num")
        println(" also resultHere ${num.also(::println)}")
        val value = num.apply {
            num = 20
        }
        println(" apply resultHere $value")

        val resultRun = "number".run {
            val tail = substring(1)
            tail.toUpperCase(Locale.ROOT)
        }
        println(" run resultHere $resultRun")
        val resultWith = with("number") {
            val tail = substring(1)
            tail.toUpperCase(Locale.ROOT)
        }
        println(" with resultHere $resultWith")


        /* val arr = arrayListOf(
             arrayListOf(1, 2, 3),
             arrayListOf(4, 5, 6),
             arrayListOf(7, 8, 9)

         )
         fun rowSum(row: Int) = arr[row].sum()
         fun colSum(col: Int) = arr.sumBy {row -> row[col] }*/
}
}

/*
let resultHere 11
11
also resultHere 11
apply resultHere 11
run resultHere UMBER
with resultHere UMBER*/
