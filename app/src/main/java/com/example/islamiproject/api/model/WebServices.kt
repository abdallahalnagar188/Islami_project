package com.example.islamiproject.api.model

import retrofit2.http.GET
import retrofit2.http.Query

interface WebServices {

    @GET("https://mp3quran.net/api/v3/")
    fun getSources(): retrofit2.Call<RadioResponse>

}