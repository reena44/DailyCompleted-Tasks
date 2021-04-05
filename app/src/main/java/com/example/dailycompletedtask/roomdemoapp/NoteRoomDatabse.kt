package com.example.dailycompletedtask.roomdemoapp

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.dailycompletedtask.roomdatabase.MyDatabase

@Database(entities = [Note::class], version = 1)
abstract class NoteRoomDatabse:RoomDatabase(){

    abstract fun daoAccess():DaoAccess1
    private var noteRoomDatabse: NoteRoomDatabse? = null

    companion object {
        var INSTANCE: NoteRoomDatabse? = null

        fun getAppDataBase(context: Context): NoteRoomDatabse? {
            if (INSTANCE == null){
                synchronized(NoteRoomDatabse::class){
                    INSTANCE = Room.databaseBuilder(context.applicationContext, NoteRoomDatabse::class.java, "myDB").build()
                }
            }
            return INSTANCE
        }

        fun destroyDataBase(){
            INSTANCE = null
        }
    }

}