package com.example.bookstore

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.rememberNavBackStack
import com.example.bookstore.navigation.BookstoreNavigation
import com.example.bookstore.navigation.BookstoreRoute

@Composable
fun BookStoreApp(modifier: Modifier = Modifier) {
    val backStack = rememberNavBackStack(
        BookstoreRoute.Home
    )


    Scaffold(
        bottomBar = {
            BottomNavigationBar(
                backStack = backStack,

                )
        }
    ) { paddingValues ->


        BookstoreNavigation(
            modifier = Modifier.padding(paddingValues),
            backStack = backStack,
        )
    }
}