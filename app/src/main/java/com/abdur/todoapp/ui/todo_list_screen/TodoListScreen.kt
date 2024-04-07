package com.abdur.todoapp.ui.todo_list_screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.abdur.todoapp.data.Todo
import com.abdur.todoapp.ui.add_todo.AddTodoPopUp
import com.abdur.todoapp.util.UiEvents
import kotlinx.coroutines.flow.collect

@Composable
fun TodoListScreen(
    onNavigate: (String) -> Unit,
) {

    val viewmodel: TodoListViewModel = hiltViewModel()
    val todos by viewmodel.todos.collectAsState(initial = emptyList())


    LaunchedEffect(key1 = true) {
        viewmodel.uiEvents.collect {
            when (it) {
                is UiEvents.OnNavigate -> onNavigate(it.route)
                else -> Unit
            }
        }
    }

    Scaffold(
        modifier = Modifier,
        floatingActionButton = {
            FloatingActionButton(onClick = {
                viewmodel.isDialogVisible = !viewmodel.isDialogVisible
            }) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Add Todo")
            }
        }
    ) { paddingValues ->
        if (viewmodel.isDialogVisible){
            AddTodoPopUp()
        }

        LazyColumn(modifier = Modifier.padding(paddingValues)) {
            items(todos.size) { currentTodo ->
                TodoItem(
                    todo = todos[currentTodo],
                    onDoneChange = viewmodel::onEvent,
                    onDeleteTodo = viewmodel::onEvent
                )
            }
        }
    }
}
