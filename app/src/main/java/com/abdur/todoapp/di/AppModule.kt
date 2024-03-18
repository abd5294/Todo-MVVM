package com.abdur.todoapp.di

import android.content.Context
import androidx.room.Room
import com.abdur.todoapp.data.TodoDatabase
import com.abdur.todoapp.data.TodoRepository
import com.abdur.todoapp.data.TodoRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideTodoDatabase(
        @ApplicationContext context : Context
    ) : TodoDatabase{
        return Room.databaseBuilder(
            context,
            TodoDatabase::class.java,
            "todo_db"
        ).build()
    }

    @Provides
    @Singleton
    fun provideTodoRepository(db : TodoDatabase) : TodoRepository{
        return TodoRepositoryImpl(db.dao)
    }
}