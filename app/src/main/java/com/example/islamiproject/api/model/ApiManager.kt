package com.example.islamiproject.api.model

import com.example.islamiproject.Constants
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class ApiManager {
    companion object{
        private var retrofit: Retrofit? = null
        private fun getInstance(): Retrofit{

            if (retrofit == null){
                retrofit = Retrofit.Builder().
                baseUrl(Constants.BASE_URL).
                addConverterFactory(GsonConverterFactory.create()).
                build()

            }
            return retrofit!!
        }
        fun gatApis(): WebServices{
            return getInstance().create(WebServices::class.java)
        }

    }
}