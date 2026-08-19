package com.example.book.presentation.di

import com.example.presentation.viewmodel.SearchViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val bookSearchPresentationModule = module {
    viewModel {
        SearchViewModel(get())
    }
}