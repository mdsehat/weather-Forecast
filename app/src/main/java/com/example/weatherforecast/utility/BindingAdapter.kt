package com.example.weatherforecast.utility

import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.example.weatherforecast.R
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

class BindingAdapter {
    companion object {
        private const val TAG = "BindingAdapterMe"

        // binding adapter for image topic for home fragment
        @BindingAdapter(
            value = ["setSRC", "setDt", "setSunrise", "setSunset", "setTimezone"],
            requireAll = false
        )
        @JvmStatic
        fun setSRC(
            imageView: ImageView,
            idWeather: Int,
            dt: Long,
            sunrise: Long,
            sunset: Long,
            timezone: Long
        ) {
            when (idWeather) {
                800 -> {
                    // it's for set night mood or day mood
                    var time = convertTimeToGMT(dt, timezone)
                    var timeSunrise = convertTimeToGMT(sunrise, timezone)
                    var timeSunset = convertTimeToGMT(sunset, timezone)
                    if ((time > timeSunrise) && (time < timeSunset)) {
                        // day
                        imageView.setImageResource(R.drawable.sunny_photo)
                    } else {
                        // night
                        imageView.setImageResource(R.drawable.night_photo_v2)
                    }
                }
                801, 802, 803, 804 -> {
                    imageView.setImageResource(R.drawable.cloud_photo_v2)
                }
                idWeather / 100 -> {
                    when (idWeather / 100) {
                        2 -> {
                            imageView.setImageResource(R.drawable.thunderstorm_photo)
                        }
                        3, 5 -> {
                            imageView.setImageResource(R.drawable.rainy_photo)
                        }
                        6 -> {
                            imageView.setImageResource(R.drawable.snow_photo)
                        }
                    }
                }
            }
        }

        // binding adapter for icon weather for home fragment
        @BindingAdapter(
            value = ["setIcon", "setDt", "setSunrise", "setSunset", "setTimezone"],
            requireAll = false
        )
        @JvmStatic
        fun setIcon(
            imageView: ImageView,
            idWeather: Int,
            dt: Long,
            sunrise: Long,
            sunset: Long,
            timezone: Long
        ) {
            when (idWeather) {
                800 -> {
                    // it's for set night mood or day mood
                    var time = convertTimeToGMT(dt, timezone)
                    var timeSunrise = convertTimeToGMT(sunrise, timezone)
                    var timeSunset = convertTimeToGMT(sunset, timezone)
                    if ((time > timeSunrise) && (time < timeSunset)) {
                        // day
                        imageView.setImageResource(R.drawable.sunny)
                        imageView.setColorFilter(R.color.myYellow)
                    } else {
                        // night
                        imageView.setImageResource(R.drawable.night)
                        imageView.setColorFilter(R.color.myYellow)
                    }

                }
                801, 802, 803, 804 -> {
                    imageView.setImageResource(R.drawable.cloud)
                    imageView.setColorFilter(R.color.myBlue)
                }
                idWeather / 100 -> {
                    when (idWeather / 100) {
                        2 -> {
                            imageView.setImageResource(R.drawable.thunderstorm)
                            imageView.setColorFilter(R.color.myDarkGray)

                        }
                        3, 5 -> {
                            imageView.setImageResource(R.drawable.rainy)
                            imageView.setColorFilter(R.color.myBlue)
                        }
                        6 -> {
                            imageView.setImageResource(R.drawable.snow_photo)
                            imageView.setColorFilter(R.color.myWhite)
                        }
                        7 -> {
                            imageView.setImageResource(R.drawable.wind)
                            imageView.setColorFilter(R.color.myDarkGray)
                        }
                    }
                }
            }
        }

        // binding adapter for time for home fragment
        @BindingAdapter(value = ["setDt", "setTimeZone"], requireAll = true)
        @JvmStatic
        fun setTime(textView: TextView, dt: Long, timezone: Long) {
            textView.text = convertTimeToGMT(dt, timezone) + " "
        }

        // binding adapter for sunrise/sunset for home fragment
        @BindingAdapter(value = ["setSun", "setTimeZone"], requireAll = true)
        @JvmStatic
        fun setSun(textView: TextView, sun: Long, timezone: Long) {
            textView.text = convertTimeToGMT(sun, timezone) + " "

        }

        private fun convertTimeToGMT(time: Long, timezone: Long): String {
            var dateFormat: DateFormat = SimpleDateFormat("HH:mm")
            dateFormat.timeZone = TimeZone.getTimeZone("GMT")
            return dateFormat.format((time + timezone) * 1000)
        }
    }

}