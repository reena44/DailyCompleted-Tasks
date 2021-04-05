/*
package com.example.dailycompletedtask.roomdatabase.kotlinroom

import android.annotation.SuppressLint
import android.content.Intent
import android.os.AsyncTask
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.example.dailycompletedtask.R
import com.example.dailycompletedtask.roomdatabase.MyDatabase
import com.example.dailycompletedtask.roomdatabase.RecyclerViewAdapter
import com.example.dailycompletedtask.roomdatabase.RecyclerViewAdapter.ClickListener
import com.example.dailycompletedtask.roomdatabase.Todo
import com.example.dailycompletedtask.roomdatabase.TodoNoteActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.util.*

class MainActivity: AppCompatActivity(), ClickListener, OnItemSelectedListener {
    var myDatabase: MyDatabase? = null
    var recyclerView: RecyclerView? = null
    var spinner: Spinner? = null
    var recyclerViewAdapter: RecyclerViewAdapter? = null
    var floatingActionButton: FloatingActionButton? = null
    private val categories = arrayOf(
        "All",
        "Android",
        "iOS",
        "Kotlin",
        "Swift"
    )
    var todoArrayList = ArrayList<Todo>()
    var spinnerList = ArrayList(Arrays.asList(*categories))
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.room_main)
        initViews()
        myDatabase = Room.databaseBuilder(
            applicationContext,
            MyDatabase::class.java, MyDatabase.DB_NAME
        ).fallbackToDestructiveMigration().build()
        checkIfAppLaunchedFirstTime()
        spinner!!.onItemSelectedListener = this
        spinner!!.setSelection(0)
        floatingActionButton!!.setOnClickListener {
            startActivityForResult(
                Intent(
                    this,
                    TodoNoteActivity::class.java
                ),
                NEW_TODO_REQUEST_CODE
            )
        }
    }

    private fun initViews() {
        floatingActionButton = findViewById(R.id.fab)
        spinner = findViewById(R.id.spinner)
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, spinnerList)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner!!.setAdapter(adapter)
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView!!.setLayoutManager(LinearLayoutManager(this))
        recyclerViewAdapter = RecyclerViewAdapter(this)
        recyclerView!!.setAdapter(recyclerViewAdapter)
    }

    override fun launchIntent(id: Int) {
        startActivityForResult(
            Intent(
                this,
                TodoNoteActivity::class.java
            ).putExtra("id", id), UPDATE_TODO_REQUEST_CODE
        )
    }

    override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
        if (position == 0) {
            loadAllTodos()
        } else {
            val string = parent.getItemAtPosition(position).toString()
            loadFilteredTodos(string)
        }
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {}
    @SuppressLint("StaticFieldLeak")
    private fun loadFilteredTodos(category: String) {
        object : AsyncTask<String?, Void?, List<Todo>>() {

            override fun onPostExecute(todoList: List<Todo>) {
                recyclerViewAdapter!!.updateTodoList(todoList)
            }

            override fun doInBackground(vararg params: String?): List<Todo> {
                return myDatabase!!.daoAccess().fetchTodoListByCategory(params[0])

            }
        }.execute(category)
    }

    @SuppressLint("StaticFieldLeak")
    private fun fetchTodoByIdAndInsert(id: Int) {
        object : AsyncTask<Int?, Void?, Todo>() {

            override fun onPostExecute(todoList: Todo) {
                recyclerViewAdapter!!.addRow(todoList)
            }

            override fun doInBackground(vararg params: Int?): Todo {
                return myDatabase!!.daoAccess().fetchTodoListById(params[0]!!)

            }
        }.execute(id)
    }

    @SuppressLint("StaticFieldLeak")
    private fun loadAllTodos() {
        object : AsyncTask<String?, Void?, List<Todo>>() {


            override fun onPostExecute(todoList: List<Todo>) {
                recyclerViewAdapter!!.updateTodoList(todoList)
            }

            override fun doInBackground(vararg p0: String?): List<Todo> {
                return myDatabase!!.daoAccess().fetchAllTodos()

            }
        }.execute()
    }

    private fun buildDummyTodos() {
        var todo = Todo()
        todo.name = "Android Retrofit Tutorial"
        todo.description =
            "Cover a tutorial on the Retrofit networking library using a RecyclerView to show the data."
        todo.category = "Android"
        todoArrayList.add(todo)
        todo = Todo()
        todo.name = "iOS TableView Tutorial"
        todo.description = "Covers the basics of TableViews in iOS using delegates."
        todo.category = "iOS"
        todoArrayList.add(todo)
        todo = Todo()
        todo.name = "Kotlin Arrays"
        todo.description =
            "Cover the concepts of Arrays in Kotlin and how they differ from the Java ones."
        todo.category = "Kotlin"
        todoArrayList.add(todo)
        todo = Todo()
        todo.name = "Swift Arrays"
        todo.description =
            "Cover the concepts of Arrays in Swift and how they differ from the Java and Kotlin ones."
        todo.category = "Swift"
        todoArrayList.add(todo)
        insertList(todoArrayList)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK) {

            //reset spinners
            spinner!!.setSelection(0)
            if (requestCode == NEW_TODO_REQUEST_CODE) {
                val id = data!!.getLongExtra("id", -1)
                Toast.makeText(applicationContext, "Row inserted", Toast.LENGTH_SHORT).show()
                fetchTodoByIdAndInsert(id.toInt())
            } else if (requestCode == UPDATE_TODO_REQUEST_CODE) {
                val isDeleted = data!!.getBooleanExtra("isDeleted", false)
                val number = data.getIntExtra("number", -1)
                if (isDeleted) {
                    Toast.makeText(applicationContext, "$number rows deleted", Toast.LENGTH_SHORT)
                        .show()
                } else {
                    Toast.makeText(applicationContext, "$number rows updated", Toast.LENGTH_SHORT)
                        .show()
                }
                loadAllTodos()
            }
        } else {
            Toast.makeText(applicationContext, "No action done by user", Toast.LENGTH_SHORT).show()
        }
    }

    @SuppressLint("StaticFieldLeak")
    private fun insertList(todoList: List<Todo>) {
        object : AsyncTask<List<Todo?>?, Void?, Void?>() {

            override fun onPostExecute(voids: Void?) {
                super.onPostExecute(voids)
            }

            override fun doInBackground(vararg params: List<Todo?>?): Void? {
                myDatabase!!.daoAccess().insertTodoList(params[0])
                return null
            }
        }.execute(todoList)
    }

    private fun checkIfAppLaunchedFirstTime() {
        val PREFS_NAME = "SharedPrefs"
        val settings = getSharedPreferences(PREFS_NAME, 0)
        if (settings.getBoolean("firstTime", true)) {
            settings.edit().putBoolean("firstTime", false).apply()
            buildDummyTodos()
        }
    }

    companion object {
        const val NEW_TODO_REQUEST_CODE = 200
        const val UPDATE_TODO_REQUEST_CODE = 300
    }
}*/
