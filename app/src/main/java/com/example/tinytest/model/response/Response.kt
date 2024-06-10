package com.example.tinytest.model.response

import com.google.gson.annotations.SerializedName

data class TinyResponse(
    @SerializedName("list") val list: List<Tiny>
)

data class Tiny(
    @SerializedName("id") val id : String,
    @SerializedName("title") val name : String,
    @SerializedName("geocoordinates") val description : String,
    @SerializedName("image") val imageUrl: String

)