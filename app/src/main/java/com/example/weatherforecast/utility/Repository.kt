package com.example.weatherforecast.utility

import androidx.lifecycle.LiveData
import com.example.weatherforecast.model.InfoWeatherModel
import io.reactivex.rxjava3.core.Single

class Repository {

    companion object{
        private var instance : Repository ?= null
        fun getInstance():Repository{
            if (instance == null){
                instance = Repository()
            }
            return instance!!
        }
    }

    fun getCurrentWeather(cityName : String, units: String, appId : String):Single<InfoWeatherModel>{
        return RetrofitInstance.getInstance().getCurrentWeather(cityName, units, appId)
    }
}