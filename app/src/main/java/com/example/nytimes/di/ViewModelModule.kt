package com.example.nytimes.di

import com.example.nytimes.viewmodels.NYViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val moduleViewModel = module{
    viewModel{
        NYViewModel(get())
    }
}