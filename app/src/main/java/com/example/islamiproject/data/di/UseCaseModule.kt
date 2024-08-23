package com.example.islamiproject.data.di

import com.example.islamiproject.doman.repo.RadioRepo
import com.example.islamiproject.doman.usecase.GetRadio
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {
    @Provides
    fun provideUseCase(brokersRepo: RadioRepo): GetRadio {
        return GetRadio(brokersRepo)
    }
}