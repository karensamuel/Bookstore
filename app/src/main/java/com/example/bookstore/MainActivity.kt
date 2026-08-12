package com.example.bookstore

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.book.presentation.BookListRoute


import com.example.bookstore.ui.theme.BookStoreTheme
import com.example.bookinfo.presentation.components.BookDetailsScreen
import com.example.searchbook.presentation.SearchRoute


class MainActivity : ComponentActivity() {

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            BookStoreTheme {

                val navController = rememberNavController()


                    NavGraph(navController)

            }
        }
    }
}

@Composable
fun NavGraph(navController: NavHostController) {

    NavHost(
        navController = navController,
        startDestination = "home"
    ) {

        composable("home") {
            HomeRoute()
        }
        composable("bookinfo") {
            BookInfo()
        }
    }
}

@Composable
fun BookInfo( modifier: Modifier = Modifier) {
    BookDetailsScreen( bookid = "1")

}

@Composable
fun HomeRoute(modifier: Modifier = Modifier) {
    Column() {
        SearchRoute()
        BookListRoute()
    }


}