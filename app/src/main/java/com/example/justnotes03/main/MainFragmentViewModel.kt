package com.example.justnotes03.main

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.justnotes03.room.AppNote
import com.example.justnotes03.room.NoteRepository
import com.example.justnotes03.room.NoteRoomDatabase
import com.example.justnotes03.utils.REPOSITORY

class MainFragmentViewModel(application: Application) : AndroidViewModel(application) {
    private val context: Context = application
    lateinit var liveData: LiveData<List<AppNote>>

    fun initDatabase() {
        val daoNotes = NoteRoomDatabase.getInstance(context).getDao()
        REPOSITORY = NoteRepository(daoNotes)
        liveData  = REPOSITORY.getAllNotes()
    }

}