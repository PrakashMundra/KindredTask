package com.kindredtask.data.local

import android.arch.lifecycle.LiveData
import com.kindredtask.data.DataSourceKt
import com.kindredtask.data.model.GameKt

class LocalDataSourceKt : DataSourceKt {
    override fun getGamesList(): LiveData<List<GameKt>>? {
        return null
    }
}