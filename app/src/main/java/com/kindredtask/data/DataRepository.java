package com.kindredtask.data;

import android.arch.lifecycle.LiveData;

import com.kindredtask.data.local.LocalDataSource;
import com.kindredtask.data.model.Game;
import com.kindredtask.data.remote.RemoteDataSource;

import java.util.List;

public class DataRepository implements DataSource {
    private static DataRepository INSTANCE;
    private RemoteDataSource mRemoteDataRepository;
    private LocalDataSource mLocalDataSource;

    private DataRepository() {
        this.mRemoteDataRepository = new RemoteDataSource();
        this.mLocalDataSource = new LocalDataSource();
    }

    public static DataRepository getInstance() {
        if (INSTANCE == null) {
            synchronized (DataRepository.class) {
                INSTANCE = new DataRepository();
            }
        }
        return INSTANCE;
    }

    @Override
    public LiveData<List<Game>> getGamesList() {
        return mRemoteDataRepository.getGamesList();
    }
}
