package com.example.dailycompletedtask

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_checkbox_selection.*

class CheckboxSelection : AppCompatActivity(),TestAdapter.OnItemClickListener{
    lateinit var adapter :TestAdapter
    var dataList = ArrayList<TestData>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_checkbox_selection)
        setDataList()
        searchlist()

        rv_data.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        adapter = TestAdapter(this, dataList)
        rv_data.adapter = adapter
    }

    private fun searchlist() {

        edt_search.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun afterTextChanged(p0: Editable?) {
                filter(p0.toString());
            }

        })
    }

    fun filter(text: String?) {
        val temp = ArrayList<TestData>()
        for (d in dataList) {
            //or use .equal(text) with you want equal match
            //use .toLowerCase() for better matches
            if (d.name.contains(text.toString())) {
                temp.add(d)
            }
        }
        //update recyclerview
        adapter.updateList(temp)
    }

    private fun setDataList() {

        for (i in 1..100) {
            dataList.add(TestData("city " + i   .toString(), false))
        }
    }

    override fun onItemClick(position: Int, value: String) {
        tv_getData.text = value
        adapter.setChecked(position)
    }

    fun allSelection(view: View) {
        adapter.setAll(true)
    }

    fun allUnselection(view: View) {
        adapter.setAll(false)
    }
}