package com.example.tinytest.model.api

import com.example.tinytest.model.response.Tiny
import com.example.tinytest.model.response.TinyResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

class TinyWebService {
    private lateinit var api: MealApi
    init{
        val retrofit = Retrofit.Builder()
            .baseUrl("https://raw.githubusercontent.com/worldline-spain/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        api = retrofit.create(MealApi::class.java)
    }

    suspend fun getTiny() : List<Tiny>{
        return api.getMeals().list
    }

    interface MealApi{
        @GET("technical_test_backend/main/pois.json")
        suspend fun getMeals() : TinyResponse
    }
}