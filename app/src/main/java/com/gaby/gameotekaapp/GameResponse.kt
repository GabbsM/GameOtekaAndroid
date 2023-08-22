package com.gaby.gameotekaapp

import com.google.gson.annotations.SerializedName

data class GameResponse(
    @SerializedName("results") val results:List<GameItemResponse>
)

data class GameItemResponse(
    @SerializedName("id") val id:Int,
    @SerializedName("name") val name:String,
    @SerializedName("released") val released:String,
    @SerializedName("background_image") val image:String,
)
