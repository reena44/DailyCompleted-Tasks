package com.example.dailycompletedtask

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_data.view.*

class TestAdapter(val onClickListener: OnItemClickListener, var dataList: ArrayList<TestData>) :RecyclerView.Adapter<TestAdapter.ViewHolder>(){
    lateinit private var value: String
    var selection = false

    fun setAll(flag: Boolean){
        selection = flag
        notifyDataSetChanged()

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_data,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.tv_data.text = dataList[position].name
        if (dataList.get(position).flag) {
            holder.itemView.checkbox.isChecked = true
        } else {
            holder.itemView.checkbox.isChecked = false
        }
        if(selection){
            holder.itemView.checkbox.isChecked = selection
        }


        holder.itemView.checkbox.setOnClickListener {
            if ( holder.itemView.checkbox.isChecked){
                 value =  dataList[position].name
            }
            onClickListener.onItemClick(position, value)
        }
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    fun updateList(temp: ArrayList<TestData>) {
        dataList = temp
        notifyDataSetChanged()


    }


    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){

    }

    fun setChecked(position: Int) {
        for (i in dataList.indices) {
            if (i != position) {
                dataList.get(i).flag = false
            }
        }
        dataList.get(position).flag = true
        notifyDataSetChanged()
    }

    interface OnItemClickListener {
        fun onItemClick(position: Int, value: String)
    }

}