package com.the.add_to_cart.domain

import kotlinx.coroutines.flow.Flow

interface CartRepository {

    fun getAll(): Flow<List<CartModel>>

    suspend fun deleteItem(item: CartModel)
}