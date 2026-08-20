package com.example.info.presentation.di

import com.example.info.presentation.viewmodel.InfoViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val bookInfoPresentationModule=module{
    viewModel {
        InfoViewModel(get())
    }
}
