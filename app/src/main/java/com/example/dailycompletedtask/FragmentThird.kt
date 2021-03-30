package com.example.dailycompletedtask

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_third.*


class FragmentThird : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_third, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val getCurrentDate = arguments?.getString("CurrentDate")
        val sortDate = arguments?.getString("SortDate")
        val sortTime = arguments?.getString("SortTime")

        if( getCurrentDate != null){
            tv_fragment_31.append(getCurrentDate.toString())
            tv_fragment_32.append(sortDate.toString())
            tv_fragment_33.append(sortTime.toString())

        }

    }
}