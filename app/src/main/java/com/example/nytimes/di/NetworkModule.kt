package com.example.nytimes.di

import com.example.nytimes.network.NYTimesApi
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

val moduleNetwork = module {
    single {
        Retrofit.Builder().run {
            baseUrl("https://api.nytimes.com")
            addConverterFactory(MoshiConverterFactory.create(moshi))
            build()
        }.create(NYTimesApi::class.java)
    }
}