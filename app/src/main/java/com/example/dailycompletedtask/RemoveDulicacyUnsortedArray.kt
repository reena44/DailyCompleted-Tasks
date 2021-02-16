package com.example.dailycompletedtask

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class RemoveDulicacyUnsortedArray : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val arr = intArrayOf(1, 2, 5, 1, 7, 2, 4, 2)
        var length = arr.size
        removeDuplicateElements(arr, length)
    }

    private fun removeDuplicateElements(arr: IntArray, size: Int) {

        val mp: HashMap<Int, Boolean> = HashMap()

        for (i in 0 until size) {
            if (mp[arr[i]] == null)
                println("After Removing Duplicate value : ${arr[i] }  ")
            mp[arr[i]] = true
        }
    }
}