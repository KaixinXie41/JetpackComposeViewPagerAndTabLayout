package com.example.jetpackcomposewithviewpageandtablayout

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun LazyColumnItemsDemo(){
    LazyColumn(){
        items((1..100).toList()){
            Text(text = "Item $it")
        }
    }
}

