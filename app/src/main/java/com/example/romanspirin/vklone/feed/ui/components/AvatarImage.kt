package com.example.romanspirin.vklone.feed.ui.components

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import com.example.romanspirin.vklone.core.util.DEFAULT_AVATAR_IMAGE
import com.example.romanspirin.vklone.core.util.loadPicture

@Composable
fun AvatarImage(
    url: String
) {
    val image = loadPicture(
        url = url,
        defaultImg = DEFAULT_AVATAR_IMAGE
    ).value

    image?.let {
        Image(
            contentDescription = "Avatar",
            bitmap = image.asImageBitmap(),
            contentScale = ContentScale.Crop
        )
    }
}