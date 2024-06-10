package com.example.tinytest.model

import com.example.tinytest.model.api.TinyWebService
import com.example.tinytest.model.response.Tiny

class TinyRepository (private val webService: TinyWebService = TinyWebService()){

    suspend fun getTiny() : List<Tiny>{
        return webService.getTiny()
    }
}