package com.example.dailycompletedtask

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class AddMatrix:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rows: Int
        val cols: Int
        var sumRow: Int
        var sumCol: Int

        //Initialize matrix a  
        val a =
            arrayOf(intArrayOf(1, 2, 3), intArrayOf(4, 5, 6))

        //Calculates number of rows and columns present in given matrix
        rows = a.size
        cols = a[0].size
        println("rows of $rows")

        println("cols of $cols")


        //Calculates sum of each row of given matrix
        for (i in 0 until rows) {
            sumRow = 0
            for (j in 0 until cols) {
                sumRow += a[i][j]
            }
            println("Sum of " + (i + 1) + " row: " + sumRow)
        }

        //Calculates sum of each column of given matrix
        for (i in 0 until cols) {
            sumCol = 0
            for (j in 0 until rows) {
                sumCol += a[j][i]
            }
            println("Sum of " + (i + 1) + " column: " + sumCol)
        }
    }
}