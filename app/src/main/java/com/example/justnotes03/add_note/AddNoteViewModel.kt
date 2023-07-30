package com.example.justnotes03.add_note

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.justnotes03.room.AppNote
import com.example.justnotes03.utils.REPOSITORY
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddNoteViewModel(private val application: Application) : AndroidViewModel(application) {
    private val context: Context = application
    fun insert(note: AppNote) {
        viewModelScope.launch(Dispatchers.IO){
            REPOSITORY.insert(note)

        }
    }



}
