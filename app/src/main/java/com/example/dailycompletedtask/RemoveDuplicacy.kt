package com.example.dailycompletedtask

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class RemoveDuplicacy : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val arr = intArrayOf(88, 10, 20, 20, 30, 88, 30, 40, 50, 50)
        var length = arr.size
        removeDuplicateElements(arr, length)
        //printing array elements


    }

    private fun removeDuplicateElements(arr: IntArray, size: Int) {
        arr.sort()
        if (size == 0 || size == 1) {
            Log.d(" Array after removing ", "duplicate elements is $size")
        }
        val temp = IntArray(size)
        var newArray = 0
        for (i in 0 until size - 1) {
            if (arr[i] != arr[i + 1]) {
                temp[newArray++] = arr[i]

            }
        }
        temp[newArray++] = arr[size - 1]

        for (i in 0 until newArray) {
            arr[i] = temp[i]
        }
        for (i in 0 until newArray)

            Log.d(" Array after removing ", "duplicate elements is ${arr[i]}")
    }
}