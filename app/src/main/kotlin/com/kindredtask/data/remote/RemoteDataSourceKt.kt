package com.kindredtask.data.remote

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MediatorLiveData
import android.util.Log
import com.google.gson.Gson
import com.kindredtask.api.ApiKt
import com.kindredtask.data.DataSourceKt
import com.kindredtask.data.model.Game
import com.kindredtask.data.model.GameKt
import org.json.JSONException
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.util.*

class RemoteDataSourceKt : DataSourceKt {
    private var mApi: ApiKt

    companion object {
        private const val BASE_URL = "https://api.unibet.com/game-library-rest-api/"
    }

    init {
        val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .build()
        mApi = retrofit.create(ApiKt::class.java)
    }

    override fun getGamesList(): LiveData<List<GameKt>>? {
        /*val data = MediatorLiveData<List<Game>>()
        mApi.getGamesList().enqueue(object : Callback<String> {
            override fun onResponse(call: Call<String>?, response: Response<String>?) {
                response?.let {
                    try {
                        val games = response.body()
                        val gamesList = ArrayList<GameKt>()
                        val jObject = JSONObject(games?.trim())
                        val keys = jObject.keys()
                        while (keys.hasNext()) {
                            val key = keys.next() as String
                            val keyObject = jObject.get(key)
                            if (keyObject is JSONObject) {
                                val gameKeys = keyObject.keys()
                                while (gameKeys.hasNext()) {
                                    val gameKey = gameKeys.next() as String
                                    val game = keyObject.get(gameKey)
                                    if (game is JSONObject)
                                        gamesList.add(Gson().fromJson(game.toString(), GameKt::class.java))
                                }
                            }
                        }
                        data.value = gamesList
                    } catch (e: JSONException) {
                        Log.e("getGamesList", e.message)
                        data.value = null
                    }

                } ?: kotlin.run { data.value = null }
            }

            override fun onFailure(call: Call<String>?, t: Throwable?) {
                data.value = null
            }
        })*/
        return null
    }
}