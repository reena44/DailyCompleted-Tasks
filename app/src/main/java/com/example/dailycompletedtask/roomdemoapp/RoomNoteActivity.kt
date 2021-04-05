package com.example.dailycompletedtask.roomdemoapp

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.dailycompletedtask.R
import kotlinx.android.synthetic.main.activity_room_note.*

class RoomNoteActivity : AppCompatActivity() {
     val NOTEADDED: String  ="data"
    lateinit var roomDatabse :NoteRoomDatabse
    lateinit var daoAccess: DaoAccess1


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        roomDatabse  = NoteRoomDatabse.getAppDataBase(application)!!
        daoAccess = roomDatabse.daoAccess()
        setContentView(R.layout.activity_room_note)
        btn_add.setOnClickListener {
            if (TextUtils.isEmpty(edt_note.text.toString())){
                Toast.makeText(this, "please fill note first", Toast.LENGTH_LONG).show()
            }
            else{
                val intent = Intent()
                val noteData = edt_note.text.toString()
                intent.putExtra(NOTEADDED, noteData)
                setResult(RESULT_OK, intent)
                finish()

            }
        }
    }
}