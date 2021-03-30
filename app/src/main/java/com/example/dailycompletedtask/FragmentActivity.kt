package com.example.dailycompletedtask

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import java.text.DateFormat
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class FragmentActivity : AppCompatActivity() {
    val dateArray: MutableList<String> = ArrayList()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment2)
        setFragment()
    }

    private fun sortList(): ArrayList<String> {


        var l: ArrayList<String> = ArrayList()
        l.add("8:00 am")
        l.add("8:32 am")
        l.add("8:10 am")
        l.add("1:00 pm")
        l.add("3:00 pm")
        l.add("2:00 pm")

        Collections.sort(l, Comparator<String?> { o1, o2 ->
            try {
                return@Comparator SimpleDateFormat("hh:mm a").parse(o1)
                    .compareTo(SimpleDateFormat("hh:mm a").parse(o2))
            } catch (e: ParseException) {
                return@Comparator 0
            }
        })
        return l
    }

    fun sortDate(): MutableList<String> {
        dateArray.add("2020-03-25")
        dateArray.add("2019-01-27")
        dateArray.add("2020-03-26")
        dateArray.add("2020-02-26")
        dateArray.sort()
        return dateArray

    }

    fun setFragment(){

        val bundle = Bundle()
        val fr = FragmentThird()

        bundle.putString("CurrentDate", getDate())
        bundle.putString("SortDate", sortDate().toString())
        bundle.putString("SortTime", sortList().toString())


        fr.arguments = bundle
        val ft = supportFragmentManager.beginTransaction()
        ft.add(R.id.container, fr)
        ft.commit()
    }

    private fun getDate(): String? {
        val calendar = Calendar.getInstance()
        //calendar.add(Calendar.DAY_OF_YEAR, 1)
        val tomorrow = calendar.time
        val dateFormat: DateFormat = SimpleDateFormat("dd-MMM-yyyy, hh:mm a", Locale.getDefault())
        return dateFormat.format(tomorrow)
    }
}
/*
val times = ArrayList<String>()
times.add("8:00 pm")
times.add("4:00 am")
times.add("9:00 pm")
times.add("7:00 am")
val dates = ArrayList<Date>()
val format: DateFormat = SimpleDateFormat("h:m a", Locale.ENGLISH)
for (time in times) {
    dates.add(format.parse(time))
}
dates.sort()*/
