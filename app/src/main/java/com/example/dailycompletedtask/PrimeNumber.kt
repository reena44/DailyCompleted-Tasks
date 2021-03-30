package com.example.dailycompletedtask

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class PrimeNumber : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_prime_number)

        var i: Int
        var m = 0
        var flag = 0
        val n = 3 //it is the number to be checked

        m = n / 2
        if (n == 0 || n == 1) {
            println("$n is not prime number")
        } else {
            i = 2
            while (i <= m) {
                if (n % i == 0) {
                    println("$n is not prime number")
                    flag = 1
                    break
                }
                i++
            }
            if (flag == 0) {
                println("$n is prime number")
            }
        } //end of else


    }
}