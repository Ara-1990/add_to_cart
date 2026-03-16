package com.the.add_to_cart.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage

@Composable
fun Cart(
    navController: NavController,
    cartViewModel: CartViewModel

) {
    val cartItems by cartViewModel.cartItems.collectAsState()

    Column {

        Button(
            onClick = { cartViewModel.clearCart() }
        ) {
            Text("Clear Cart")
        }

        LazyColumn {

            items(cartItems) { item ->

                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier.fillMaxWidth()) {

                    AsyncImage(
                        model = item.image,
                        contentDescription = null,
                        modifier = Modifier.height(80.dp)
                    )

                    Text(
                        text = item.name,
                        fontSize = 20.sp
                    )
                    Button(
                        onClick = {
                            cartViewModel.deleteItem(item)
                        }
                    ) {
                        Text("Remove")
                    }
                }
            }
        }
    }

}

