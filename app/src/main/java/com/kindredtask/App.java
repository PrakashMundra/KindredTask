package com.kindredtask;

import android.app.Application;

import com.kindredtask.data.DataRepository;

public class App extends Application {
    public DataRepository getRepository() {
        return DataRepository.getInstance();
    }
}
