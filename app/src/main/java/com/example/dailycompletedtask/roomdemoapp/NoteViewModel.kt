package com.example.dailycompletedtask.roomdemoapp

import android.app.Activity
import android.app.Application
import android.content.Intent
import android.content.Intent.getIntent
import android.os.AsyncTask
import android.util.Log
import androidx.lifecycle.AndroidViewModel

class NoteViewModel:AndroidViewModel {

     var roomDatabse :NoteRoomDatabse
     var daoAccess: DaoAccess1

    constructor(application: Application):super(application){
        roomDatabse  = NoteRoomDatabse.getAppDataBase(application)!!
        /*roomDatabse = Room.databaseBuilder(
            application,
            NoteRoomDatabse::class.java, "MyDatabase.DB_NAME"
        ).build()*/
        daoAccess = roomDatabse.daoAccess()
}

     fun insertRow(note: Note) {

        InsertAsyncTask(daoAccess!!).execute(note)

    }
    class InsertAsyncTask(daoAccess: DaoAccess1):AsyncTask<Note, Unit, Unit>() {

        var daoAccess = daoAccess

        override fun doInBackground(vararg note: Note?) {
            daoAccess.insert(note[0]!!)
            Log.d("hkkkkkkkk", daoAccess.fetchAllTodos()[1].note.toString())
            Log.d("hkkkkkkkk", daoAccess.fetchAllTodos()[2].note.toString())
            Log.d("hkkkkkkkk", daoAccess.fetchAllTodos()[3].note.toString())

        }
    }
}