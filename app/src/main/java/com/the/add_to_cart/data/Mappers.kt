package com.the.add_to_cart.data
import com.the.add_to_cart.domain.CartModel


fun CartEntity.toDomain()=
    CartModel( id = id, name = name, image =  image)