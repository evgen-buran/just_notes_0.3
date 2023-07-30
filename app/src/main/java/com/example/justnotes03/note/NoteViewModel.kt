package com.example.justnotes03.note

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.justnotes03.room.AppNote
import com.example.justnotes03.utils.APP_ACTIVITY
import com.example.justnotes03.utils.REPOSITORY
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NoteViewModel : ViewModel() {
    fun delete(note: AppNote) {
        viewModelScope.launch (Dispatchers.IO){
            REPOSITORY.delete(note)
        }
    }
}