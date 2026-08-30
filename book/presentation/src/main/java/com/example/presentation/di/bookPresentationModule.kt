package com.example.presentation.di

import com.example.book.presentation.viewmodel.BookViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val bookPresentationModule = module {
    viewModel {
        BookViewModel(get())
    }
}