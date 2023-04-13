package com.example.notestv.models

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.notestv.database.NoteDateBase
import com.example.notestv.database.NoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NoteViewModel (application: Application) : AndroidViewModel(application) {
    private val repository : NoteRepository

    val allnotes : LiveData<List<Note>>

    init {
        val dao = NoteDateBase.getDataBase(application).getNoteDao()
        repository = NoteRepository(dao)
        allnotes  = repository.allNotes
    }

    fun deleteNote(note: Note) = viewModelScope.launch  (Dispatchers.IO) {

        repository.delete(note)

    }
    fun insertNote(note: Note) = viewModelScope.launch (Dispatchers.IO){
        repository.insert(note)

    }
     fun updateNote (note: Note)  = viewModelScope.launch (Dispatchers.IO){
         repository.update(note)
     }
}