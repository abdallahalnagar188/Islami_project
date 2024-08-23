package com.example.islamiproject.data.di

import com.example.islamiproject.data.remot.ApiService
import com.example.islamiproject.data.repo.RadioRepoImpl
import com.example.islamiproject.doman.repo.RadioRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepoModule {
    @Provides
    fun provideRepository(apiService: ApiService): RadioRepo {
        return RadioRepoImpl(apiService)
    }
}
