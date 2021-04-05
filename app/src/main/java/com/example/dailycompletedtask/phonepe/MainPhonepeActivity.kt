package com.example.dailycompletedtask.phonepe

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.dailycompletedtask.R
import com.phonepe.intent.sdk.api.PhonePe
import com.phonepe.intent.sdk.api.PhonePeInitException
import com.phonepe.intent.sdk.api.TransactionRequest
import com.phonepe.intent.sdk.api.TransactionRequestBuilder
import kotlinx.android.synthetic.main.activity_main_phonepe.*


class MainPhonepeActivity : AppCompatActivity() {
    private val DEBIT_REQUEST_CODE = 777


    var apiEndPoint = "/v4/debit"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_phonepe)
        PhonePe.init(this)
        btn_phn.setOnClickListener {
            try {
                PhonePe.isUPIAccountRegistered { show ->
                    Log.d("TAG", "onResponse: $show")
                    Toast.makeText(this, if (show) "YES" else "NO", Toast.LENGTH_SHORT)
                        .show()
                }
            } catch (e: PhonePeInitException) {
                e.printStackTrace()
            }
        }
       // apiInit()


    }

    private fun apiInit() {

        val headers: MutableMap<String, String> = HashMap()
        headers["X-CALLBACK-URL"] = "https://www.demoMerchant.com" // Merchant server URL

        headers["X-CALL-MODE"] = "POST"
        val debitRequest: TransactionRequest = TransactionRequestBuilder()
            /*.setData(base64Body)
            .setChecksum(checksum)*/
            .setUrl(apiEndPoint)
            //.setHeaders(headers)
            .build()
//For Intent SDK call below function
//For Intent SDK call below function
        /*try {
            startActivityForResult(
                PhonePe.getTransactionIntent(
                    this, debitRequest
                ), DEBIT_REQUEST_CODE
            )
        } catch (e: PhonePeInitException) {
        }*/
    }
}