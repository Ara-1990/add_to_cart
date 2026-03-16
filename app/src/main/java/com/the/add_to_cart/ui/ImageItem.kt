package com.the.add_to_cart.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import androidx.compose.material3.Text
import com.the.add_to_cart.domain.ImagesModel


@Composable
fun ImageItem(iamges_model: ImagesModel, onClick: (ImagesModel) -> Unit) {
    Card(modifier = Modifier.padding(8.dp)) {

        Column {

            AsyncImage(
                model = iamges_model.image,
                contentDescription = null,
                modifier = Modifier
                    .height(150.dp)
                    .fillMaxWidth()
            )
            Text(text = iamges_model.name)


            Button(
                onClick = {
                    onClick(iamges_model)
                }
            ) {
                Text("Add to cart")
            }
        }

    }

}