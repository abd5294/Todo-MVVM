package com.abdur.todoapp.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface TodoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTodo(todo : Todo)

    @Delete
    suspend fun deleteTodo(todo : Todo)

    @Query("SELECT * from Todo")
    fun getAllTodo() : Flow<List<Todo>>
}