package com.example.justnotes03.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "table_notes")
data class AppNote(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo val titleNote: String,
    @ColumnInfo val textNote: String,
//    @ColumnInfo val dateNote: String,
) : Serializable