package com.the.add_to_cart.ui


import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController

@Composable
fun ImageScreen(
    navController: NavController,
    viewModel: ImageViewModel = viewModel()) {

    val images by viewModel.images.collectAsState()

    LazyColumn {

        items(images) { item ->
              ImageItem(
                  iamges_model = item,
                  onClick = {
                      viewModel.addToCart(it)

                  }

              )


        }

    }

}