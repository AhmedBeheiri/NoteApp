package com.example.noteapp.data.note

import com.example.noteapp.database.NoteDatabase
import com.example.noteapp.domain.note.Note
import com.example.noteapp.domain.note.NoteDataSource
import com.example.noteapp.domain.time.DateTimeUtil

class SqlDelightNoteDataSource(db: NoteDatabase) :NoteDataSource {
    private val queries = db.notesQueries
    override suspend fun getAllNotes(): List<Note> {
        return queries.getAllNotes().executeAsList().map { it.toNote() }
    }

    override suspend fun getNoteById(id: Long): Note? {
        return queries.getNoteById(id).executeAsOneOrNull()?.toNote()
    }

    override suspend fun insertNote(note: Note) {
       queries.insertNote(
           id = note.id,
           title = note.title,
           content = note.content,
           colorHex = note.colorHex,
           created = DateTimeUtil
               .toEpochMilliSeconds(note.created),
       )
    }

    override suspend fun deleteNoteById(id: Long) {
       queries.deleteNote(id)
    }
}