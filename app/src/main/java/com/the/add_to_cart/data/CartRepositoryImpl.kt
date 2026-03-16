package com.the.add_to_cart.data

import com.the.add_to_cart.domain.CartModel
import com.the.add_to_cart.domain.CartRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class CartRepositoryImpl(private val dao: CartDao) : CartRepository {

    override fun getAll(): Flow<List<CartModel>> {

        return dao.getAll().map { it -> it.map { it.toDomain() } }
    }


    suspend fun clearCart() {
        dao.clearCart()
    }

    override suspend fun deleteItem(item: CartModel) {

        dao.delete(
            CartEntity(
                id = item.id,
                name = item.name,
                image = item.image
            )
        )
    }
}