package com.kindredtask.data

import android.arch.lifecycle.LiveData
import com.kindredtask.data.local.LocalDataSourceKt
import com.kindredtask.data.model.Game
import com.kindredtask.data.model.GameKt
import com.kindredtask.data.remote.RemoteDataSourceKt

class DataRepositoryKt : DataSourceKt {
    private var mLocalDataSource: LocalDataSourceKt
    private var mRemoteDataSource: RemoteDataSourceKt

    init {
        mLocalDataSource = LocalDataSourceKt()
        mRemoteDataSource = RemoteDataSourceKt()
    }

    companion object {
        private var INSTANCE: DataRepositoryKt? = null

        fun getInstance(): DataRepositoryKt? {
            if (INSTANCE == null)
                return DataRepositoryKt()
            return INSTANCE;
        }
    }

    override fun getGamesList(): LiveData<List<GameKt>>? {
        return mRemoteDataSource.getGamesList()
    }
}