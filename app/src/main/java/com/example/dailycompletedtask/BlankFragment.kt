package com.example.dailycompletedtask

import android.R.attr.key
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_blank.*


class BlankFragment(context: SendMessageListener): Fragment() {
     var  sendMessage:SendMessageListener = context

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btn_1.setOnClickListener {
            sendMessage.passMessage(edt_1.text.toString())

        }
        btn_2.setOnClickListener {
            startActivity(Intent(context,FragmentActivity::class.java))
        }

    }
    interface SendMessageListener{
        fun passMessage( msg:String)

    }
}