package com.example.history.presentation.di

import com.example.history.presentation.viewmodel.BookHistoryViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val BookHistoryPresntationModule =  module {
    viewModel {
        BookHistoryViewModel(get(), get())
    }
}