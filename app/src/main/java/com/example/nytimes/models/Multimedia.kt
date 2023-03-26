package com.example.nytimes.models

import com.squareup.moshi.Json

data class Multimedia(@Json(name="url") val url: String)