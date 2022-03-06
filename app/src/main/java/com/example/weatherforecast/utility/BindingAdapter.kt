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
        @BindingAdapter("setSRC")
        @JvmStatic
        fun setSRC(imageView: ImageView, idWeather: Int) {
            Log.i(TAG, "setSRC: " + idWeather)
            when (idWeather) {
                800 -> {
                    imageView.setImageResource(R.drawable.sunny_photo)
                }
                801, 802, 803, 804 -> {
                    imageView.setImageResource(R.drawable.clouds_photo)
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
        @BindingAdapter("setIcon")
        @JvmStatic
        fun setIcon(imageView: ImageView, idWeather: Int) {
            when (idWeather) {
                800 -> {
                    imageView.setImageResource(R.drawable.sunny)
                    imageView.setColorFilter(R.color.myYellow)
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
        fun setTime(textView: TextView, dt: Long, timezone: Long){
            var dateFormat: DateFormat = SimpleDateFormat("HH:mm")
            dateFormat.timeZone = TimeZone.getTimeZone("GMT")
            var time = dateFormat.format((dt + timezone) * 1000)
            textView.text = time
        }

        // binding adapter for sunrise/sunset for home fragment
        @BindingAdapter(value = ["setSun", "setTimeZone"], requireAll = true)
        @JvmStatic
        fun setSun(textView: TextView, sun: Long, timezone: Long){
            var dateFormat: DateFormat = SimpleDateFormat("HH:mm")
            dateFormat.timeZone = TimeZone.getTimeZone("GMT")
            var time = dateFormat.format((sun + timezone) * 1000)
            textView.text = time
        }
    }
}