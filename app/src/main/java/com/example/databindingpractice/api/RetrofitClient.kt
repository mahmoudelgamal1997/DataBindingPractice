package com.example.databindingpractice.api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


private val BASE_URL = "https://reqres.in/api/"

object RetrofitClient {

    fun getClient():APIService{


        val okHttpClient = OkHttpClient.Builder()
            .connectTimeout(60,TimeUnit.SECONDS)
            .build()


        return Retrofit.Builder()
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(APIService::class.java)
    }

}