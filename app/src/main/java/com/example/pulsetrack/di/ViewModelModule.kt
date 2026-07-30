package com.example.pulsetrack.di

import com.example.pulsetrack.presentation.home.HomeViewModel
import com.example.pulsetrack.presentation.run.RunViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        RunViewModel(get())
    }
    viewModel {
        HomeViewModel()
    }
}