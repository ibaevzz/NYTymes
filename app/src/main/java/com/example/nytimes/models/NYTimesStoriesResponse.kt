package com.example.nytimes.models

import com.squareup.moshi.Json

data class NYTimesStoriesResponse(@Json(name="results") val stories: List<NYTimesStory>)