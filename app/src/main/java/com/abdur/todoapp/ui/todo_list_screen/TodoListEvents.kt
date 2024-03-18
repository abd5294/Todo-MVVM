package com.abdur.todoapp.ui.todo_list_screen

import com.abdur.todoapp.data.Todo

sealed class TodoListEvents{
    data class OnDoneChange(val todo : Todo, val isDone : Boolean) : TodoListEvents()
    data class OnCreateTodo(val todo : Todo) : TodoListEvents()
}