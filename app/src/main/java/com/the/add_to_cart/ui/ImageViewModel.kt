package com.the.add_to_cart.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.the.add_to_cart.data.AppDb
import com.the.add_to_cart.data.ImageRepository
import com.the.add_to_cart.domain.ImagesModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ImageViewModel(application: Application) : AndroidViewModel(application) {

    private val dao = AppDb.getDatabase(application).userDao()

    private val repository = ImageRepository(dao)


    private val _images = MutableStateFlow<List<ImagesModel>>(emptyList())
    val images: StateFlow<List<ImagesModel>> = _images

    init {
        loadImages()
    }

    private fun loadImages() {
        _images.value = repository.getImages()
    }

    fun addToCart(item: ImagesModel) {
        viewModelScope.launch {
            repository.addToCart(item)
        }
    }
}