package com.example.notestv.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.notestv.models.Note
import com.example.notestv.utilites.DATABASE_NAME


@Database(entities = arrayOf(Note::class), version = 1, exportSchema = false)
abstract class NoteDateBase : RoomDatabase() {

    abstract fun getNoteDao() : NoteDao

    companion object {
        private var INSTANCE: NoteDateBase? = null

        fun getDataBase(context: Context): NoteDateBase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    NoteDateBase::class.java,
                    DATABASE_NAME
                ).build()

                INSTANCE = instance

                instance
            }
        }
    }
}