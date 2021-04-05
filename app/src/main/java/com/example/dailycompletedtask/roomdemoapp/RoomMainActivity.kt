package com.example.dailycompletedtask.roomdemoapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.AsyncTask
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dailycompletedtask.R
import kotlinx.android.synthetic.main.activity_room_main.*
import java.util.*

class RoomMainActivity : AppCompatActivity() {
    private lateinit var roomDataAdapter: RoomDataAdapter
    private val NEW_ROOM_REQUEST_CODE: Int= 1
    lateinit var noteViewModel: NoteViewModel
    lateinit var roomDatabse :NoteRoomDatabse
    lateinit var daoAccess: DaoAccess1



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room_main)
            roomDatabse  = NoteRoomDatabse.getAppDataBase(application)!!
            daoAccess = roomDatabse.daoAccess()
        setRecyclerView()

        noteViewModel = ViewModelProviders.of(this).get(NoteViewModel::class.java)

        fab_room.setOnClickListener {
            startActivityForResult(
                Intent(this, RoomNoteActivity::class.java),
                NEW_ROOM_REQUEST_CODE
            )
        }
    }

    private fun setRecyclerView() {
        rv_data.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        roomDataAdapter = RoomDataAdapter(mutableListOf())
        rv_data.adapter = roomDataAdapter
        fetchDataList()
    }
    @SuppressLint("StaticFieldLeak")
    private fun fetchDataList() {
        object : AsyncTask<String?, Void?, List<Note>>() {

            override fun onPostExecute(todoList: List<Note>) {
                roomDataAdapter.updateTodoList(todoList)
            }

            override fun doInBackground(vararg p0: String?): List<Note> {
                return roomDatabse.daoAccess().fetchAllTodos()

            }
        }.execute()
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == NEW_ROOM_REQUEST_CODE && resultCode == RESULT_OK){

            var note = Note()
            val id = UUID.randomUUID().toString()
            var notedata = data!!.getStringExtra(RoomNoteActivity().NOTEADDED)
            //note.id = id
            note.note = notedata
            noteViewModel.insertRow(note)
            Toast.makeText(this, "note save", Toast.LENGTH_LONG).show()
        }
        else{
            Toast.makeText(this, "can't save", Toast.LENGTH_LONG).show()

        }
    }

}
