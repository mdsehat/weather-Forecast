package com.example.weatherforecast.utility

import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class RetrofitInstance {


    companion object {
        public val APP_KEY: String = "9ca85da7a62e023df78328e876b79750"
        private val BASE_URL: String = "https://api.openweathermap.org/"
        private var instance: Retrofit? = null
        fun getInstance(): API {
            if (instance == null) {
                instance = Retrofit.Builder().baseUrl(BASE_URL)
                    .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return instance!!.create(API::class.java)
        }
    }
}