package com.example.mouseandroid

import retrofit2.http.GET

interface AppService {
    @GET("/")
    fun getAppData():retrofit2.Call<ResponseArray<User>>

    @GET("/v1/good")
    fun getGoodData():retrofit2.Call<ResponseArray<Good>>
}