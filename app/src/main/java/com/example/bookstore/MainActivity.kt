package com.example.bookstore


import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.book.presentation.BookList
import com.example.book.presentation.model.BookIntent
import com.example.book.presentation.viewmodel.BookViewModel
import com.example.bookstore.ui.theme.BookStoreTheme
import com.example.core.domain.model.result.onError
import com.example.core.domain.model.result.onSuccess
import com.example.info.domain.BookInfoRepo
import com.example.info.domain.model.BookInfoModel
import com.example.info.presentation.BookDetailsScreen
import com.example.info.presentation.model.InfoIntent
import com.example.info.presentation.viewmodel.InfoViewModel
import com.example.presentation.model.UiBookModel
import com.example.presentation.viewmodel.SearchViewModel
import com.example.searchbook.presentation.SearchRoute
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject
import org.koin.androidx.compose.koinViewModel


class MainActivity : ComponentActivity() {


    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()


        setContent {
            BookStoreTheme {

                val navController = rememberNavController()


                NavGraph(


                    navController = navController,



                    )

            }
        }
    }


}

@Composable
fun NavGraph(
    navController: NavHostController,


) {

    NavHost(
        navController = navController,
        startDestination = "home"
    ) {

        composable("home") {
            HomeRoute(onBookClick = { bookId ->
                val normalizedId = bookId.removePrefix("/works/")

                navController.navigate("bookinfo/$normalizedId")
            })
        }
        composable("bookinfo/{bookId}") { backStackEntry ->


            val bookId = requireNotNull(
                backStackEntry.arguments?.getString("bookId")
            )

            BookInfo(
                bookId = bookId
            )
        }
    }
}


@Composable
fun BookInfo(
    bookId: String,
) {
    val infoViewModel: InfoViewModel = koinViewModel()
    LaunchedEffect(bookId) {
        bookId.let {
            infoViewModel.onIntent(InfoIntent.onLoadPage(it))
        }
    }
        BookDetailsScreen(
            bookViewModel = infoViewModel
        )

}

@Composable
fun HomeRoute(
    modifier: Modifier = Modifier,
    onBookClick: (String) -> Unit
) {
    val bookViewModel: BookViewModel = koinViewModel()
    val searchViewModel: SearchViewModel = koinViewModel()

    val bookState by bookViewModel.uiState.collectAsStateWithLifecycle()
    val searchState by searchViewModel.uiState.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        bookViewModel.onIntent(BookIntent.LoadBooks)
    }

    Column {

        SearchRoute(
            viewModel = searchViewModel
        )

        if (searchState.query.isBlank()) {

            BookList(
                bookModels = bookState.books,
                onBookClick = onBookClick
            )

        } else {

            val books = searchState.books.map { book ->
                UiBookModel(
                    id = book.id,
                    title = book.title,
                    authors = book.authors.toImmutableList(),
                    coverUrl = book.coverUrl
                )
            }.toImmutableList()

            BookList(
                bookModels = books.toImmutableList(),
                onBookClick = onBookClick
            )
        }
    }
}