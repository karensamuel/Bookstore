package com.example.searchbook.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.presentation.components.SearchBar

@Composable
fun SearchRoute() {

    var query by remember { mutableStateOf("") }

    SearchBar(

        query = query,
        onQueryChange = { query = it }
    )
}