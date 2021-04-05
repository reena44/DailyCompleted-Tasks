package com.example.dailycompletedtask.roomdemoapp

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "notes")
class Note :Serializable{

    @PrimaryKey (autoGenerate = true)
    var id :Int?= null

    @ColumnInfo(name = "note")
    var note:String?= null
}