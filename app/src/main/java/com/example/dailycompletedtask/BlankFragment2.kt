package com.example.dailycompletedtask

import android.Manifest.permission
import android.content.Context
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.app.ActivityCompat.requestPermissions
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_blank2.*


class BlankFragment2(context: Context) : Fragment() {


    private val REQUEST_LOCATION: Int = 101

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        btn_3.setOnClickListener {
            if (ActivityCompat.checkSelfPermission(
                    context?.applicationContext!!,
                    permission.ACCESS_FINE_LOCATION
                ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                    context?.applicationContext!!,
                    permission.ACCESS_COARSE_LOCATION
                ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                    context?.applicationContext!!,
                    permission.CAMERA
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                requestPermissions(
                    requireActivity(), arrayOf(
                        permission.ACCESS_COARSE_LOCATION,
                        permission.ACCESS_FINE_LOCATION,
                        permission.CAMERA

                    ),
                    REQUEST_LOCATION
                )
            } else {
                Log.e("DB", "PERMISSION GRANTED")
            }

        }


    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        if (requestCode == REQUEST_LOCATION){
            if (grantResults.isNotEmpty() &&  grantResults[0] == PackageManager.PERMISSION_GRANTED){
                var bundle = arguments?.getString("data")
                if (bundle != null)
                    tv_frg2.text = bundle.toString()

                Toast.makeText(context, "permission granted", Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(context, "permission denied", Toast.LENGTH_LONG).show()

            }

        }

    }
}