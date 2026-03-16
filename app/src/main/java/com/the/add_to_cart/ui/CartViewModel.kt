package com.the.add_to_cart.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.the.add_to_cart.data.AppDb
import com.the.add_to_cart.data.CartRepositoryImpl
import com.the.add_to_cart.domain.CartModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class CartViewModel(application: Application) : AndroidViewModel(application) {

    private val dao = AppDb.getDatabase(application).userDao()
    private val repository = CartRepositoryImpl(dao)

    val cartItems = repository.getAll().stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(5000),
        emptyList()
    )


    fun deleteItem(item: CartModel) {
        viewModelScope.launch {
            repository.deleteItem(item)
        }
    }

    fun clearCart() {
        viewModelScope.launch {
            repository.clearCart()
        }
    }
}