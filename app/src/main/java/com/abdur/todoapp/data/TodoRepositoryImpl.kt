package com.abdur.todoapp.data

import kotlinx.coroutines.flow.Flow

class TodoRepositoryImpl(
    private val dao : TodoDao
) : TodoRepository {
    override fun getTodos(): Flow<List<Todo>> {
        return dao.getAllTodo()
    }

    override suspend fun insertTodo(todo: Todo) {
        return dao.insertTodo(todo)
    }

    override suspend fun deleteTodo(todo: Todo) {
        return dao.deleteTodo(todo)
    }
}