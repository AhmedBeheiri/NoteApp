package com.example.noteapp.di

import com.example.noteapp.data.local.DatabaseDriverFactory
import com.example.noteapp.data.note.SqlDelightNoteDataSource
import com.example.noteapp.database.NoteDatabase
import com.example.noteapp.domain.note.NoteDataSource

class DatabaseModule {
    private val factory by lazy{ DatabaseDriverFactory() }
     val noteDataSource:NoteDataSource by lazy{
        SqlDelightNoteDataSource(NoteDatabase(factory.createDriver()))
    }

}
