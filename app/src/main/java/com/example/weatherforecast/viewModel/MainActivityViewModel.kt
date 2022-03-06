package com.example.weatherforecast.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.weatherforecast.model.InfoWeatherModel
import com.example.weatherforecast.utility.Repository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.core.SingleObserver
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers

class MainActivityViewModel: ViewModel() {
    private val TAG = "MainActivityViewModel"
    fun getCurrentWeather(cityName : String, units:String, appId : String):LiveData<InfoWeatherModel>{
        var liveData = MutableLiveData<InfoWeatherModel>()
        Repository.getInstance().getCurrentWeather(cityName, units, appId).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : SingleObserver<InfoWeatherModel> {
                override fun onSubscribe(d: Disposable?) {

                }

                override fun onSuccess(t: InfoWeatherModel?) {
                    liveData.value = t!!
                }

                override fun onError(e: Throwable?) {
                    Log.i(TAG, "onError: " + e!!.message)
                }

            })

        return liveData

    }
}