package com.example.bookstore

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey
import com.example.bookstore.navigation.BookstoreRoute

@Composable
fun BottomNavigationBar(backStack: NavBackStack<NavKey>) {
    val currentDestination = backStack.lastOrNull()

    NavigationBar {

        NavigationBarItem(
            selected = currentDestination == BookstoreRoute.Home,
            onClick = {
                if (currentDestination != BookstoreRoute.Home) {

                    backStack.add(BookstoreRoute.Home)
                }
            },
            icon = {
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = "Home"
                )
            },
            label = {
                Text("Home")
            }
        )

        NavigationBarItem(
            selected = currentDestination == BookstoreRoute.History,
            onClick = {
                if (currentDestination != BookstoreRoute.History) {

                    backStack.add(BookstoreRoute.History)
                }
            },
            icon = {
                Icon(
                    imageVector = Icons.Default.History,
                    contentDescription = "History"
                )
            },
            label = {
                Text("History")
            }
        )
    }
}