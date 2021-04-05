/*
package com.example.dailycompletedtask.roomdatabase

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.dailycompletedtask.R
import java.util.*

class RecyclerViewAdapter(private val clickListener: ClickListener) :
    RecyclerView.Adapter<com.example.dailycompletedtask.roomdatabase.RecyclerViewAdapter44.RecyclerViewAdapter.ViewHolder>() {
    private val todoList: MutableList<Todoo55>
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recyclerview_item_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val todo = todoList[position]
        holder.txtName.text = todo.name
        holder.txtNo.text = "#" + todo.todo_id.toString()
        holder.txtDesc.text = todo.description
        holder.txtCategory.text = todo.category
    }

    override fun getItemCount(): Int {
        return todoList.size
    }

    fun updateTodoList(data: List<Todoo55>) {
        todoList.clear()
        todoList.addAll(data)
        notifyDataSetChanged()
    }

    fun addRow(data: Todoo55) {
        todoList.add(data)
        notifyDataSetChanged()
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var txtName: TextView
        var txtNo: TextView
        var txtDesc: TextView
        var txtCategory: TextView
        var cardView: CardView

        init {
            txtNo = view.findViewById(R.id.txtNo)
            txtName = view.findViewById(R.id.txtName)
            txtDesc = view.findViewById(R.id.txtDesc)
            txtCategory = view.findViewById(R.id.txtCategory)
            cardView = view.findViewById(R.id.cardView)
            cardView.setOnClickListener { clickListener.launchIntent(todoList[adapterPosition].todo_id) }
        }
    }

    interface ClickListener {
        fun launchIntent(id: Int)
    }

    init {
        todoList = ArrayList()
    }
}*/
