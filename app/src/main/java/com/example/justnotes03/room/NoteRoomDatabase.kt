package com.example.justnotes03.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [AppNote::class], version = 1)
abstract class NoteRoomDatabase : RoomDatabase() {
    abstract fun getDao(): DaoNotes

    companion object {
        @Volatile
        private var database: NoteRoomDatabase? = null

        @Synchronized
        fun getInstance(context: Context): NoteRoomDatabase {
            if (database == null) {
                database =
                    Room.databaseBuilder(
                        context,
                        NoteRoomDatabase::class.java,
                        "noteDB"
                    ).build()
                return database as NoteRoomDatabase
            } else {
                return database as NoteRoomDatabase
            }

        }
    }
}