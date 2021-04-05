package com.example.dailycompletedtask.roomdemoapp

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.dailycompletedtask.roomdatabase.MyDatabase
import com.example.dailycompletedtask.roomdatabase.Todo

@Dao
interface DaoAccess1 {

    @Insert
    fun insert(note: Note)

    @Query("SELECT * FROM " + "notes")
    fun fetchAllTodos(): List<Note>

}