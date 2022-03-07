package com.example.weatherforecast.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.weatherforecast.R
import com.example.weatherforecast.databinding.HomeFragmentBinding
import com.example.weatherforecast.model.InfoWeatherModel
import com.example.weatherforecast.utility.RetrofitInstance
import com.example.weatherforecast.viewModel.MainActivityViewModel

class FragmentHome : Fragment() {
    private val TAG = "FragmentHome"
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var homeFragmentBinding : HomeFragmentBinding = DataBindingUtil.
        inflate(inflater, R.layout.home_fragment, container, false)
        var viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        viewModel.getCurrentWeather("yazd", "metric", RetrofitInstance.APP_KEY)
            .observe(viewLifecycleOwner, object : Observer<InfoWeatherModel> {
                override fun onChanged(t: InfoWeatherModel?) {
                    Log.i(TAG, "onChanged: " + t!!.coord!!.lat.toString())
                    homeFragmentBinding.model = t!!
                }

            })
        return homeFragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}