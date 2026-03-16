package com.the.add_to_cart.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import com.the.add_to_cart.domain.ImagesModel


@Composable
fun NavGraph() {
    val navController = rememberNavController()

    val cartViewModel: CartViewModel = viewModel()
    val cartItems by cartViewModel.cartItems.collectAsState()

    Scaffold(
    bottomBar = {

        NavigationBar {
            NavigationBarItem(
                selected = false,
                onClick = {
                    navController.navigate("home") {
                        popUpTo(navController.graph.findStartDestination().id) { saveState = true }
                        launchSingleTop = true; restoreState = true
                    }
                },

                icon = { Icon(Icons.Outlined.Home, null) },

                )

            NavigationBarItem(
                selected = false,
                onClick = {
                    navController.navigate("cart") {
                        popUpTo(navController.graph.findStartDestination().id) { saveState = true }
                        launchSingleTop = true; restoreState = true
                    }
                },


                icon = {
                    BadgedBox(
                        badge = {
                            if (cartItems.isNotEmpty()) {
                                Badge {
                                    Text(cartItems.size.toString())
                                }
                            }
                        }
                    ) {
                        Icon(Icons.Outlined.ShoppingCart, null)
                    }
                       },

                )


        }
    }
    ){ padding->
        NavHost(
            navController = navController,
            startDestination = "home",
            modifier = Modifier.padding(padding)
        ){
            composable("home") {
                ImageScreen(navController)
            }


            composable("cart") {
                Cart(navController, cartViewModel)
            }


        }
    }




}