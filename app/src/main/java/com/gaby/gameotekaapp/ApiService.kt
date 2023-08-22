package com.gaby.gameotekaapp

import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("games?key=0e4861144c0844e98cd8b3b469211c65")
    suspend fun givemeAllGames():Response<GameResponse>
}