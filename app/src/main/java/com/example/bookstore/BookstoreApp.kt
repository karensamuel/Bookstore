package com.example.bookstore

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.rememberNavBackStack
import com.example.bookstore.navigation.BookstoreNavigation
import com.example.bookstore.navigation.BookstoreRoute

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BookStoreApp(modifier: Modifier = Modifier) {
    val backStack = rememberNavBackStack(
        BookstoreRoute.Home
    )
    val currentDestination = backStack.lastOrNull()

    Scaffold(
        topBar = {
            when (currentDestination) {
                BookstoreRoute.Home -> {
                    TopAppBar(
                        title = {
                            Text("Book Store")
                        }
                    )
                }

                BookstoreRoute.History -> {
                    TopAppBar(
                        title = {
                            Text("History")
                        }
                    )
                }

                is BookstoreRoute.BookInfo -> {
                    TopAppBar(
                        title = {
                            Text("Book Details")
                        }
                    )
                }

                null -> {}
            }},
        bottomBar = {
            BottomNavigationBar(
                backStack = backStack
            )
        }
    ) { paddingValues ->
        BookstoreNavigation(
            modifier = Modifier.padding(paddingValues),
            backStack = backStack,
        )
    }
}