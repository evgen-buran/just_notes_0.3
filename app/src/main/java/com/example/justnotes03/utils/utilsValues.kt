package com.example.justnotes03.utils

import android.widget.Toast
import com.example.justnotes03.MainActivity
import com.example.justnotes03.room.NoteRepository

lateinit var REPOSITORY: NoteRepository
lateinit var APP_ACTIVITY:MainActivity

fun showToast(msg: String) {
    Toast.makeText(APP_ACTIVITY, msg, Toast.LENGTH_SHORT).show()
}