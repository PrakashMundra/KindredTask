package com.kindredtask.viewmodel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MediatorLiveData
import android.databinding.ObservableBoolean
import android.support.annotation.NonNull
import com.kindredtask.data.DataRepositoryKt
import com.kindredtask.data.model.GameKt

class ListViewModelKt(@NonNull application: Application) : AndroidViewModel(application) {
    var loading = ObservableBoolean(true)
    var isEmpty = ObservableBoolean(false)

    fun getGamesList(): LiveData<List<GameKt>> {
        val observable = MediatorLiveData<List<GameKt>>()
        DataRepositoryKt.getInstance()?.let {
            val todoList = it.getGamesList()
            todoList?.let {
                observable.addSource(it, observable::setValue)
            }
        }
        return observable
    }
}