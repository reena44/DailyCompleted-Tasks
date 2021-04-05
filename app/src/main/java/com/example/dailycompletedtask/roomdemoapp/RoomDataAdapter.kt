package com.example.dailycompletedtask.roomdemoapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dailycompletedtask.R
import com.example.dailycompletedtask.roomdatabase.Todo
import kotlinx.android.synthetic.main.item_room_data.view.*

class RoomDataAdapter(var arrayList: MutableList<Note>) :RecyclerView.Adapter<RoomDataAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_room_data,
                parent,
                false
            )
        )

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.tv_id.text = arrayList[position].id.toString()
        holder.itemView.tv_data.text = arrayList[position].note.toString()
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    fun updateTodoList(todoList: List<Note>) {
        arrayList.clear()
        arrayList.addAll(todoList)
        notifyDataSetChanged()
    }
    fun addRow(data: Note) {
        arrayList.add(data)
        notifyDataSetChanged()
    }


    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){

    }

}