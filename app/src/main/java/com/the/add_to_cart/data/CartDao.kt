package com.the.add_to_cart.data

import androidx.room.Insert
import androidx.room.Query
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.OnConflictStrategy
import kotlinx.coroutines.flow.Flow


@Dao
interface CartDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(images: CartEntity)

    @Query("SELECT * FROM cart")
    fun getAll(): Flow<List<CartEntity>>

    @Query("DELETE FROM cart")
    suspend fun clearCart()

    @Delete
    suspend fun delete(item: CartEntity)

}