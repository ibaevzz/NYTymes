package com.example.nytimes.models

import com.squareup.moshi.Json

data class NYTimesStory(@Json(name="title") val title: String,
                        @Json(name="url") val url: String,
                        @Json(name="multimedia") val multimedia: List<Multimedia>)