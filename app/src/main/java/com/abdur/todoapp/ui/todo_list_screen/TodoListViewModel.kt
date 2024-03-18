package com.abdur.todoapp.ui.todo_list_screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.abdur.todoapp.data.Todo
import com.abdur.todoapp.data.TodoRepository
import com.abdur.todoapp.ui.add_todo.AddTodoPopUp
import com.abdur.todoapp.util.Routes
import com.abdur.todoapp.util.UiEvents
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TodoListViewModel @Inject constructor(
    private val repository : TodoRepository
) : ViewModel() {

    val todos = repository.getTodos()
    var isDialogVisible by mutableStateOf(false)

    private val _uiEvents = Channel<UiEvents>()
    val uiEvents = _uiEvents.receiveAsFlow()

    fun onEvent(event : TodoListEvents) {

        when(event){
            is TodoListEvents.OnDoneChange -> {
                viewModelScope.launch {
                    repository.insertTodo(
                        event.todo.copy(
                            isDone = event.isDone
                        )
                    )
                }
            }

            is TodoListEvents.OnCreateTodo -> {
                viewModelScope.launch {
                    repository.insertTodo(event.todo)
                }
                isDialogVisible = !isDialogVisible
            }
        }
    }
}