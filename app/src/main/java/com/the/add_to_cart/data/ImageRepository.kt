package com.the.add_to_cart.data

import com.the.add_to_cart.R
import com.the.add_to_cart.domain.ImagesModel

class ImageRepository(private val dao: CartDao) {
    fun getImages(): List<ImagesModel> {
        return listOf(
            ImagesModel(1, "City 1", R.drawable.ciity1),
            ImagesModel(2, "City 2", R.drawable.city2),
            ImagesModel(3, "City 3", R.drawable.city3),
            ImagesModel(4, "City 4", R.drawable.city4),
            ImagesModel(5, "City 5", R.drawable.city5)
        )
    }

   suspend fun addToCart(item: ImagesModel) {
        dao.insert(
            CartEntity(
                name = item.name,
                image = item.image
            )
        )
    }
}