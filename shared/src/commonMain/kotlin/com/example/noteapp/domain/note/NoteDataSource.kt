package com.example.noteapp.domain.note

interface NoteDataSource {
    suspend fun getAllNotes():List<Note>
    suspend fun getNoteById(id:Long):Note?
    suspend fun insertNote (note: Note)
    suspend fun deleteNoteById(id:Long)
}