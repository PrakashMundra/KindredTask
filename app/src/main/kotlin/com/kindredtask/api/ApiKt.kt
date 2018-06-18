package com.kindredtask.api

import retrofit2.Call
import retrofit2.http.GET

interface ApiKt {
    @GET("getGamesByMarketAndDevice.json?jurisdiction=UK&brand=unibet&deviceGroup=mobilephone&locale=en_GB&currency=GBP&categories=casino,softgames&clientId=casinoapp")
    fun getGamesList(): Call<String>
}