package com.example.bookstore


import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.book.presentation.BookListRoute
import com.example.bookinfo.domain.repo.BookInfoRepo
import com.example.bookinfo.presentation.components.BookDetailsScreen
import com.example.bookstore.ui.theme.BookStoreTheme
import com.example.core.domain.model.result.onError
import com.example.core.domain.model.result.onSuccess
import com.example.domain.repo.BookRepository
import com.example.domain.repo.model.Book
import com.example.info.domain.model.BookInfoModel
import com.example.searchbook.domain.SearchRepo
import com.example.searchbook.presentation.SearchRoute
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject


class MainActivity : ComponentActivity() {
    private val bookRepository: BookRepository by inject()
    private val searchRepo: SearchRepo by inject()
    private val bookInfoRepo: BookInfoRepo by inject()
    private var bookInfo by mutableStateOf<BookInfoModel?>(null)
    private var books by mutableStateOf<List<Book>>(emptyList())

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        lifecycleScope.launch {

            val result = bookRepository.getBooks()

            result.onSuccess {
                books = it
            }

            result.onError { error ->
                println("ERROR: $error")
            }
        }


        setContent {
            BookStoreTheme {

                val navController = rememberNavController()


                NavGraph(


                    navController = navController,
                    books = books,
                    bookInfo = bookInfo,
                    onSearch = ::searchBooks,
                    onBookClick = ::getBookInfo,

                    )

            }
        }
    }

    private fun searchBooks(query: String) {
        lifecycleScope.launch {
            val result = searchRepo.searchBooks(query)

            result.onSuccess { searchBooks ->
                books = searchBooks.map { searchBook ->
                    Book(
                        id = searchBook.id.removePrefix("/works/"),
                        title = searchBook.title,
                        authors = searchBook.authors,
                        coverUrl = searchBook.coverUrl
                    )
                }
            }

            result.onError {
                println("SEARCH ERROR: $it")
            }
        }
    }

    private fun getBookInfo(bookId: String) {
        lifecycleScope.launch {

            val result = bookInfoRepo.getBookDetails(bookId)

            result.onSuccess {
                bookInfo = it
            }

            result.onError {
                println("BOOK INFO ERROR: $it")
            }
        }
    }
}

@Composable
fun NavGraph(
    navController: NavHostController,
    books: List<Book>,
    bookInfo: BookInfoModel?,
    onSearch: (String) -> Unit,
    onBookClick: (String) -> Unit,
) {

    NavHost(
        navController = navController,
        startDestination = "home"
    ) {

        composable("home") {
            HomeRoute(books = books, onSearch = onSearch, onBookClick = { bookId ->
                val normalizedId = bookId.removePrefix("/works/")

                onBookClick(normalizedId)
                navController.navigate("bookinfo/$normalizedId")
            })
        }
        composable("bookinfo/{bookId}") { backStackEntry ->


            BookInfo(
                bookInfo = bookInfo
            )
        }
        }
    }


@Composable
fun BookInfo(
    bookInfo: BookInfoModel?
) {
    if (bookInfo != null) {
        BookDetailsScreen(
            book = bookInfo
        )
    } else {
        CircularProgressIndicator()
    }
}

@Composable
fun HomeRoute(
    modifier: Modifier = Modifier,
    books: List<Book>,
    onSearch: (String) -> Unit,
    onBookClick: (String) -> Unit
) {

    Column() {
        SearchRoute(onSearch = onSearch)
        BookListRoute(books = books, modifier = modifier, onBookClick = onBookClick)
    }


}
