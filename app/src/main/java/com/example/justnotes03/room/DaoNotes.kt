package com.example.justnotes03.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface DaoNotes {
    @Query("SELECT * FROM table_notes")
    fun getAllNotes(): LiveData<List<Note>>

    @Insert
    suspend fun insert()

    @Delete
    suspend fun delete()
}