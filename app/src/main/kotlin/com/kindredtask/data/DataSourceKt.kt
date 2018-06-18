package com.kindredtask.data

import android.arch.lifecycle.LiveData
import com.kindredtask.data.model.GameKt

interface DataSourceKt {
    fun getGamesList(): LiveData<List<GameKt>>?
}