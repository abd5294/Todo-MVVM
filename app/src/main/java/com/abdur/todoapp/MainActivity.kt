package com.abdur.todoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.abdur.todoapp.ui.theme.TodoAppTheme
import com.abdur.todoapp.ui.todo_list_screen.TodoItem
import com.abdur.todoapp.ui.todo_list_screen.TodoListScreen
import com.abdur.todoapp.util.Routes
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TodoAppTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = Routes.TODO_LIST_SCREEN.toString()
                ) {
                    composable(Routes.TODO_LIST_SCREEN.toString()) {
                        TodoListScreen(onNavigate = { navController.navigate(it) })
                    }
                }
            }
        }
    }
}