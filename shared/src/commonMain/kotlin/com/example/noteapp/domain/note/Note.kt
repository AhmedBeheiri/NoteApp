package com.example.noteapp.domain.note

import com.example.noteapp.presintation.*
import kotlinx.datetime.LocalDateTime

data class Note(
    val id:Long?,
    val title:String,
    val content:String,
    val colorHex:Long,
    val created:LocalDateTime
){
    companion object {
        private val colors = listOf(RedOrangeHex, RedPinkHex, BabyBlueHex, VioletHex, LightGreenHex)
        fun generateRandomColor() = colors.random()
    }
}
