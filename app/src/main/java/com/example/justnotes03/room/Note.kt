package com.example.justnotes03.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "table_notes")
data class Note(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo val titleNote: String,
    @ColumnInfo val textNote: String
)