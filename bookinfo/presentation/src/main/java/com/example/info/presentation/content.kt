package com.example.info.presentation

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import com.example.info.domain.model.BookInfoModel
import com.example.info.presentation.viewmodel.InfoViewModel


@Composable
fun BookDetailsScreen(
   bookViewModel: InfoViewModel
) {
    val book by bookViewModel.uiState.collectAsStateWithLifecycle()


    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
    ) {
        // Book cover
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(280.dp),
            contentAlignment = Alignment.Center
        ) {
            AsyncImage(
                model = book.book?.coverUrl,
                contentDescription = "Book cover",
                modifier = Modifier
                    .height(280.dp)
                    .width(180.dp)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Title
        book.book?.title?.let {
            Text(
                text = it,
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(modifier = Modifier.height(8.dp))
 Log.d("book info", "${book.book?.authors?.joinToString(", ")}")
        // Authors
        Text(
            text = "by ${book.book?.authors?.joinToString(", ")}",
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Book information
        Text(
            text = "Book Information",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(12.dp))



        BookInfoRow(
            label = "Editions",
            value = book.book?.editionCount.toString()
        )

        BookInfoRow(
            label = "ID",
            value = book.book?.id ?: " "
        )
    }
}

@Composable
private fun BookInfoRow(
    label: String,
    value: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = label,
            fontWeight = FontWeight.SemiBold
        )

        Text(
            text = value,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}
