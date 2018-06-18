package com.kindredtask.data.local;

import android.arch.lifecycle.LiveData;

import com.kindredtask.data.DataSource;
import com.kindredtask.data.model.Game;

import java.util.List;

public class LocalDataSource implements DataSource {
    @Override
    public LiveData<List<Game>> getGamesList() {
        return null;
    }
}
