package com.kindredtask.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MediatorLiveData;
import android.databinding.ObservableBoolean;
import android.support.annotation.NonNull;

import com.kindredtask.App;
import com.kindredtask.data.DataRepository;
import com.kindredtask.data.model.Game;

import java.util.List;

public class ListViewModel extends AndroidViewModel {
    public ObservableBoolean loading = new ObservableBoolean(true);
    public ObservableBoolean isEmpty = new ObservableBoolean(false);
    private DataRepository mDataRepository;

    public ListViewModel(@NonNull Application application) {
        super(application);
        this.mDataRepository = ((App) application).getRepository();
    }

    public LiveData<List<Game>> getGamesList() {
        MediatorLiveData<List<Game>> observable = new MediatorLiveData<>();
        LiveData<List<Game>> todoList = mDataRepository.getGamesList();
        observable.addSource(todoList, observable::setValue);
        return observable;
    }
}
