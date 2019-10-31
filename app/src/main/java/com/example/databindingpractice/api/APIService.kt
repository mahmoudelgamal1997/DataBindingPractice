package com.example.databindingpractice.api

import com.example.databindingpractice.Data
import com.example.databindingpractice.EmploeeModel
import retrofit2.Call
import retrofit2.http.GET

interface APIService {

    @GET("users/?per_page=12&amp;page=1")
    fun getEmployees () :Call<EmploeeModel>



}