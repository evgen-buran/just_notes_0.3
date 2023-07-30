package com.example.justnotes03.room

import androidx.lifecycle.LiveData

class NoteRepository(private val dao: DaoNotes) {

    fun getAllNotes(): LiveData<List<AppNote>> {
        return dao.getAllNotes()
    }

    suspend fun insert(note: AppNote) {
        dao.insert(note)
    }

    suspend fun delete(note: AppNote) {
        dao.delete(note)
    }
}
