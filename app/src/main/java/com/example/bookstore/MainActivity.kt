package com.example.bookstore

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController


import com.example.bookstore.ui.theme.BookStoreTheme
import com.example.core.domain.model.Book
import com.example.info.presentation.components.BookDetailsScreen
import com.example.presentation.BookList
import com.example.presentation.SearchBar

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
        startDestination = "bookinfo"
    ) {

        composable("home") {
            HomeScreen()
        }
        composable("bookinfo") {
            BookInfo()
        }
    }
}
@Composable
fun HomeScreen(modifier: Modifier = Modifier) {

    var query by remember { mutableStateOf("") }

    Column {
        SearchBar(
            query = query,
            onQueryChange = { query = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        )

            BookList(
                books = books,
                modifier = Modifier
                    .fillMaxSize()

            )


    }
}
@Composable
fun BookInfo(modifier: Modifier = Modifier) {
    BookDetailsScreen( book = books[0])

}