package com.example.weatherforecast.model

import com.google.gson.annotations.SerializedName

class InfoWeatherModel {
    @SerializedName("dt")
    var date: Long? = null
    var timezone: Long? = null

    @SerializedName("name")
    var nameCity: String? = null
    @SerializedName("coord")
    var coord: Coord? = null
    @SerializedName("weather")
    var weather = ArrayList<Weather>()
    @SerializedName("main")
    var main: Main? = null
    @SerializedName("wind")
    var wind: Wind? = null
    @SerializedName("sys")
    var sys: Sys? = null

    class Coord {
        var lat: Double? = null
        var lon: Double? = null
    }

    class Weather {
        @SerializedName("id")
        var idWeather: Int? = null
        var main: String? = null
        var description: String? = null
        var icon: String? = null
    }

    class Main {
        var temp: Double? = null

        @SerializedName("feels_like")
        var feelsLike: Double? = null

        @SerializedName("temp_min")
        var tempMin: Double? = null

        @SerializedName("temp_max")
        var tempMax: Double? = null
        var humidity: Int? = null
    }

    class Wind {
        var speed: Double? = null
    }

    class Sys {
        @SerializedName("id")
        var idCity: Int? = null

        @SerializedName("country")
        var countryCode: String? = null
        var sunrise: Long? = null
        var sunset: Long? = null
    }
}