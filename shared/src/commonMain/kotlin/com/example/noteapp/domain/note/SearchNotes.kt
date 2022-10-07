package com.example.noteapp.domain.note

import com.example.noteapp.domain.time.DateTimeUtil
import com.squareup.sqldelight.Query

class SearchNotes {
    fun execute(notes:List<Note>,query:String):List<Note>{
        if (query.isBlank()){
            return  notes
        }
        return notes.filter { it.title.trim().lowercase().contains(query.lowercase())
                || it.content.trim().lowercase().contains(query.lowercase())

        }.sortedBy {
            DateTimeUtil.toEpochMilliSeconds(it.created)
        }
    }
}