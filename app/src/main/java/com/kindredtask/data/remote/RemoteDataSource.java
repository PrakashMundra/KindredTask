package com.kindredtask.data.remote;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MediatorLiveData;
import android.util.Log;

import com.google.gson.Gson;
import com.kindredtask.api.Api;
import com.kindredtask.data.DataSource;
import com.kindredtask.data.model.Game;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class RemoteDataSource implements DataSource {
    private static final String BASE_URL = "https://api.unibet.com/game-library-rest-api/";
    private Api mApi;

    public RemoteDataSource() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();
        mApi = retrofit.create(Api.class);
    }

    @Override
    public LiveData<List<Game>> getGamesList() {
        final MediatorLiveData<List<Game>> data = new MediatorLiveData<>();
        mApi.getGamesList().enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                try {
                    String games = response.body();
                    if (games != null) {
                        List<Game> gamesList = new ArrayList<>();
                        JSONObject jObject = new JSONObject(games.trim());
                        Iterator<?> keys = jObject.keys();
                        Gson gson = new Gson();
                        while (keys.hasNext()) {
                            String key = (String) keys.next();
                            Object keyObject = jObject.get(key);
                            if (keyObject instanceof JSONObject) {
                                JSONObject gameObject = ((JSONObject) keyObject);
                                Iterator<?> gameKeys = gameObject.keys();
                                while (gameKeys.hasNext()) {
                                    String gameKey = (String) gameKeys.next();
                                    Object game = gameObject.get(gameKey);
                                    if (game instanceof JSONObject)
                                        gamesList.add(gson.fromJson(game.toString(), Game.class));
                                }
                            }
                        }
                        data.setValue(gamesList);
                    } else
                        data.setValue(null);
                } catch (JSONException e) {
                    Log.e("getGamesList", e.getMessage());
                    data.setValue(null);
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                data.setValue(null);
            }
        });
        return data;
    }
}
