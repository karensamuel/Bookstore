package com.example.bookstore


import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation3.runtime.rememberNavBackStack
import com.example.book.presentation.viewmodel.BookViewModel
import com.example.bookstore.navigation.BookstoreNavigation
import com.example.bookstore.navigation.BookstoreRoute
import com.example.bookstore.ui.theme.BookStoreTheme
import com.example.history.presentation.HistoryScreen
import com.example.history.presentation.model.BookHistoryIntent
import com.example.history.presentation.model.UiBookHistoryModel
import com.example.history.presentation.viewmodel.BookHistoryViewModel
import com.example.info.presentation.BookDetailsScreen
import com.example.info.presentation.model.InfoIntent
import com.example.info.presentation.viewmodel.InfoViewModel
import com.example.presentation.BookList
import com.example.presentation.model.BookIntent
import com.example.presentation.model.BookUiState
import com.example.presentation.model.SearchUiState
import com.example.presentation.model.UiBookModel
import com.example.presentation.viewmodel.SearchViewModel
import com.example.searchbook.presentation.SearchRoute
import kotlinx.collections.immutable.toImmutableList
import org.koin.androidx.compose.koinViewModel

class MainActivity : ComponentActivity() {


    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()


        setContent {
            BookStoreTheme {
                BookStoreApp()

            }
        }
    }


}








