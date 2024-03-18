package com.abdur.todoapp.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Todo(
    @PrimaryKey(autoGenerate = true)
    val id : Int? = null,
    val todo : String,
    val isDone : Boolean
)