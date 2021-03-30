package com.example.dailycompletedtask

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction


class FragmentInActivity:AppCompatActivity(),BlankFragment.SendMessageListener{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)
        setFragments()
    }

    private fun setFragments() {
        val fm = supportFragmentManager
        val ft: FragmentTransaction = fm.beginTransaction()
        val fragment = BlankFragment(this)
        val fragment2 = BlankFragment2(this)
        ft.add(R.id.container_1, fragment)
        ft.add(R.id.container_2, fragment2)
        ft.commit()
    }


    override fun passMessage(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
        val fm = supportFragmentManager
        val ft: FragmentTransaction = fm.beginTransaction()
        var blankFragment2 = BlankFragment2(this)
        var frmnt = FragmentThird()

        val bundle = Bundle()
        bundle.putString("data",msg)
        blankFragment2.arguments = bundle
        //ft.replace(R.id.container_1,blankFragment2)
        ft.add(R.id.container_2,blankFragment2)
        ft.addToBackStack(null);
        ft.replace(R.id.container_1,frmnt)
            .commit()

    }
 }

