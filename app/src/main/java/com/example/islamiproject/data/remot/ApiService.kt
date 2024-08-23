package com.example.islamiproject.data.remot

import com.example.islamiproject.doman.entity.RadioResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("radios?language=ar")
   suspend fun getRadios():Response<RadioResponse>
}