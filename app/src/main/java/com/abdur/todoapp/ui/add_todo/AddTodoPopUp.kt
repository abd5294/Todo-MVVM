package com.abdur.todoapp.ui.add_todo

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.abdur.todoapp.data.Todo
import com.abdur.todoapp.ui.todo_list_screen.TodoListEvents
import com.abdur.todoapp.ui.todo_list_screen.TodoListViewModel

@Composable
fun AddTodoPopUp() {

    var todo by remember {
        mutableStateOf("")
    }

    var isDone by remember {
        mutableStateOf(false)
    }

    val viewModel : TodoListViewModel = hiltViewModel()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .background(Color(105, 159, 245))
                .clip(RoundedCornerShape(12.dp))
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                TextField(value = todo, onValueChange = { todo = it })
                Spacer(modifier = Modifier.height(12.dp))
                Checkbox(checked = isDone, onCheckedChange = { isDone = it })
                Spacer(modifier = Modifier.height(12.dp))
                Button(onClick = {
                    viewModel.onEvent(TodoListEvents.OnCreateTodo(Todo(todo = todo, isDone = isDone)))
                }) {
                    Text(text = "Add Todo")
                }
            }
        }
    }
}