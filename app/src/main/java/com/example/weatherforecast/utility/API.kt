package com.example.weatherforecast.utility

import com.example.weatherforecast.model.InfoWeatherModel
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface API {

    @GET("data/2.5/weather?")
    public fun getCurrentWeather(
        @Query("q") cityName: String,
        @Query("units") units: String,
        @Query("APPID") appid : String ) : Single<InfoWeatherModel>
}