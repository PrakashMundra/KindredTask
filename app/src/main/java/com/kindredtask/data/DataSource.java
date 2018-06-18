package com.kindredtask.data;

import android.arch.lifecycle.LiveData;

import com.kindredtask.data.model.Game;

import java.util.List;

public interface DataSource {
    LiveData<List<Game>> getGamesList();
}
