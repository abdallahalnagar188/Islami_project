package com.example.islamiproject.data.repo

import com.example.islamiproject.data.remot.ApiService
import com.example.islamiproject.doman.entity.RadioResponse
import com.example.islamiproject.doman.repo.RadioRepo
import retrofit2.Response

class RadioRepoImpl(private val radioApi: ApiService): RadioRepo {
    override suspend fun getRadio(): Response<RadioResponse> {
        return radioApi.getRadios()
    }
}