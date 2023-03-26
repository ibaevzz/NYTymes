package com.example.nytimes.viewmodels

import androidx.databinding.ObservableBoolean
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.nytimes.adapter.StoriesAdapter
import com.example.nytimes.models.NYTimesStoriesResponse
import com.example.nytimes.network.NYTimesApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NYViewModel(private val timesApi: NYTimesApi): ViewModel() {
    private val liveData = MutableLiveData<NYTimesStoriesResponse>()
    val data: LiveData<NYTimesStoriesResponse> = liveData
    val adapter = StoriesAdapter()
    var isLoading: ObservableBoolean = ObservableBoolean(false)

    fun update(){
        isLoading.set(true)
        timesApi.getStories().enqueue(object: Callback<NYTimesStoriesResponse>{
            override fun onResponse(call: Call<NYTimesStoriesResponse>, response: Response<NYTimesStoriesResponse>) {
                liveData.value = response.body()
            }

            override fun onFailure(call: Call<NYTimesStoriesResponse>, t: Throwable) {
            }
        })
        isLoading.set(false)
    }

    init {
        update()
    }
}