package com.abdur.todoapp.data

import kotlinx.coroutines.flow.Flow

interface TodoRepository{

    fun getTodos() : Flow<List<Todo>>

    suspend fun insertTodo(todo : Todo)

    suspend fun deleteTodo(todo : Todo)
}