package com.example.manjaha.retrofit

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ManjahaConfig {
    private val client = OkHttpClient.Builder().build()

    private val retrofit = Retrofit.Builder()
        .baseUrl("http://192.168.127.172/Manjaha/public/api/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun<T> buildService(service: Class<T>): T{
        return retrofit.create(service)
    }
}