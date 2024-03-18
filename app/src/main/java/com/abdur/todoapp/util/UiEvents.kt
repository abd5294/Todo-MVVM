package com.abdur.todoapp.util

sealed class UiEvents {
    data class OnNavigate(val route : String) : UiEvents()
    data object PopBackStack : UiEvents()
}