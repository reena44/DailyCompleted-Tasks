/*
package com.example.dailycompletedtask.roomdatabase

import android.annotation.SuppressLint
import android.os.AsyncTask
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.room.Room
import com.example.dailycompletedtask.R
import java.util.*

class TodoNoteActivity : AppCompatActivity() {
    var spinner: Spinner? = null
    var inTitle: EditText? = null
    var inDesc: EditText? = null
    var btnDone: Button? = null
    var btnDelete: Button? = null
    var isNewTodo = false
    private val categories = arrayOf(
        "Android",
        "iOS",
        "Kotlin",
        "Swift"
    )
    var spinnerList = ArrayList(Arrays.asList(*categories))
    var myDatabase: MyDatabase? = null
    var updateTodo: Todo? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_todo_note)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        spinner = findViewById(R.id.spinner)
        inTitle = findViewById(R.id.inTitle)
        inDesc = findViewById(R.id.inDescription)
        btnDone = findViewById(R.id.btnDone)
        btnDelete = findViewById(R.id.btnDelete)
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, spinnerList)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner!!.setAdapter(adapter)
        myDatabase = Room.databaseBuilder(
            applicationContext,
            MyDatabase::class.java, MyDatabase.DB_NAME
        ).build()
        val todo_id = intent.getIntExtra("id", -100)
        if (todo_id == -100) isNewTodo = true
        if (!isNewTodo) {
            fetchTodoById(todo_id)
            btnDelete!!.setVisibility(View.VISIBLE)
        }
        btnDone!!.setOnClickListener(View.OnClickListener {
            if (isNewTodo) {
                val todo = Todo()
                todo.name = inTitle!!.getText().toString()
                todo.description = inDesc!!.getText().toString()
                todo.category = spinner!!.getSelectedItem().toString()
                insertRow(todo)
            } else {
                updateTodo!!.name = inTitle!!.getText().toString()
                updateTodo!!.description = inDesc!!.getText().toString()
                updateTodo!!.category = spinner!!.getSelectedItem().toString()
                updateRow(updateTodo)
            }
        })
        btnDelete!!.setOnClickListener(View.OnClickListener { deleteRow(updateTodo) })
    }

    @SuppressLint("StaticFieldLeak")
    private fun fetchTodoById(todo_id: Int) {
        object : AsyncTask<Int?, Void?, Todo>() {
           override fun onPostExecute(todo: Todo) {
                super.onPostExecute(todo)
                inTitle!!.setText(todo.name)
                inDesc!!.setText(todo.description)
                spinner!!.setSelection(spinnerList.indexOf(todo.category))
                updateTodo = todo
            }

            override fun doInBackground(vararg params: Int?): Todo {
                return myDatabase!!.daoAccess().fetchTodoListById(params[0]!!)
            }
        }.execute(todo_id)
    }

    @SuppressLint("StaticFieldLeak")
    private fun insertRow(todo: Todo) {
        object : AsyncTask<Todo?, Void?, Long>() {
            override fun doInBackground(vararg params: Todo?): Long {
                return myDatabase!!.daoAccess().insertTodo(params[0])
            }
            override fun onPostExecute(id: Long) {
                super.onPostExecute(id)
                val intent = intent
                intent.putExtra("isNew", true).putExtra("id", id)
                setResult(RESULT_OK, intent)
                finish()
            }


        }.execute(todo)
    }

    @SuppressLint("StaticFieldLeak")
    private fun deleteRow(todo: Todo?) {
        object : AsyncTask<Todo?, Void?, Int>() {

            override fun onPostExecute(number: Int) {
                super.onPostExecute(number)
                val intent = intent
                intent.putExtra("isDeleted", true).putExtra("number", number)
                setResult(RESULT_OK, intent)
                finish()
            }

            override fun doInBackground(vararg params: Todo?): Int {
                return myDatabase!!.daoAccess().deleteTodo(params[0])

            }
        }.execute(todo)
    }

    @SuppressLint("StaticFieldLeak")
    private fun updateRow(todo: Todo?) {
        object : AsyncTask<Todo?, Void?, Int>() {

            override fun onPostExecute(number: Int) {
                super.onPostExecute(number)
                val intent = intent
                intent.putExtra("isNew", false).putExtra("number", number)
                setResult(RESULT_OK, intent)
                finish()
            }

            override fun doInBackground(vararg params: Todo?): Int {
                return myDatabase!!.daoAccess().updateTodo(params[0])

            }
        }.execute(todo)
    }
}*/
