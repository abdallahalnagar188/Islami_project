package com.example.islamiproject.doman.usecase

import com.example.islamiproject.doman.repo.RadioRepo

class GetRadio(private val radioRepo: RadioRepo) {
    suspend operator fun invoke()= radioRepo.getRadio()
}