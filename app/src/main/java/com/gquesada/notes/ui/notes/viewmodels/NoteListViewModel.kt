package com.gquesada.notes.ui.notes.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gquesada.notes.data.datasources.LocalNoteDataSource
import com.gquesada.notes.data.repositories.NoteRepositoryImpl
import com.gquesada.notes.domain.models.NoteModel
import com.gquesada.notes.domain.repositories.NoteRepository
import com.gquesada.notes.domain.usecases.DeleteNotesUseCase
import com.gquesada.notes.domain.usecases.GetNotesUseCase

class NoteListViewModel : ViewModel() {
    private val dataSource = LocalNoteDataSource()
    private val repository: NoteRepository = NoteRepositoryImpl(dataSource)
    private val getNotesUseCase = GetNotesUseCase(repository)
    private val deleteNotesUseCase = DeleteNotesUseCase(repository)

    private val _noteListLiveData = MutableLiveData<List<NoteModel>>()
    val noteListLiveData: LiveData<List<NoteModel>>
        get() = _noteListLiveData

    fun onViewReady() {
//        val list = getNotesUseCase.execute()
//        _noteListLiveData.value = list
        getLatestNoteList()
    }

    fun deleteNote(id: Int) {
        deleteNotesUseCase.execute(id)
        getLatestNoteList()
    }

    private fun getLatestNoteList() {
        val list = getNotesUseCase.execute()
        _noteListLiveData.value = list
    }
}