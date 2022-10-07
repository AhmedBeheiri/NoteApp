package com.example.noteapp.android.note_details

data class NoteDetailsState (
    val noteTitle:String ="",
    val isNoteTitleHintVisible:Boolean = true,
    val noteContent:String = "",
    val isNoteContentHintVisble:Boolean = false,
    val noteColor:Long = 0xFFFFFFFF,
)