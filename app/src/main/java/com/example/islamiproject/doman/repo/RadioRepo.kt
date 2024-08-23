package com.example.islamiproject.doman.repo

import com.example.islamiproject.doman.entity.RadioResponse
import retrofit2.Response

interface RadioRepo {
   suspend fun getRadio(): Response<RadioResponse>
}