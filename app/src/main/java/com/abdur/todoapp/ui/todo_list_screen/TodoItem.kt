package com.abdur.todoapp.ui.todo_list_screen

import android.content.res.Resources.Theme
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.abdur.todoapp.data.Todo
import com.abdur.todoapp.ui.theme.todoItemBackground

@Composable
fun TodoItem(
    todo: Todo,
    onDoneChange: (TodoListEvents) -> Unit,
) {

    Surface(
        color = todoItemBackground,
        modifier = Modifier
            .padding(16.dp)
            .clip(RoundedCornerShape(5.dp))
    ) {
        Row(
            modifier = Modifier
                .padding(12.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = todo.todo)
            Checkbox(
                checked = todo.isDone,
                onCheckedChange = {
                    onDoneChange(TodoListEvents.OnDoneChange(todo, it))
                }
            )
        }
    }
}
