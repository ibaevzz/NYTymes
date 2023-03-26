package com.example.nytimes.network

import com.example.nytimes.models.NYTimesStoriesResponse
import retrofit2.Call
import retrofit2.http.GET

interface NYTimesApi {
    @GET("/svc/topstories/v2/world.json?api-key=OpAw6vTydaBgY5V5utpa1HoAGvfdcPb0")
    fun getStories(): Call<NYTimesStoriesResponse>
}