/*
package com.example.dailycompletedtask.roomdatabase

import androidx.room.*

@Dao
interface DaoAccess {
    @Insert
    fun insertTodo(todo: Todo?): Long

    @Insert
    fun insertTodoList(todoList: List<Todo?>?)

    @Query("SELECT * FROM " + MyDatabase.TABLE_NAME_TODO)
    fun fetchAllTodos(): List<Todo?>?

    @Query("SELECT * FROM " + MyDatabase.TABLE_NAME_TODO + " WHERE category = :category")
    fun fetchTodoListByCategory(category: String?): List<Todo?>?

    @Query("SELECT * FROM " + MyDatabase.TABLE_NAME_TODO + " WHERE todo_id = :todoId")
    fun fetchTodoListById(todoId: Int): Todo?

    @Update
    fun updateTodo(todo: Todo?): Int

    @Delete
    fun deleteTodo(todo: Todo?): Int
}*/
