package com.example.bookshelf.model

import kotlinx.serialization.Serializable

@Serializable
data class BookResponse(
    val items: List<Book>? = null
)

@Serializable
data class Book(
    val id: String,
    val volumeInfo: VolumeInfo? = null
)

@Serializable
data class VolumeInfo(
    val title: String? = null,
    val authors: List<String>? = null,
    val imageLinks: ImageLinks? = null
)

@Serializable
data class ImageLinks(
    val thumbnail: String? = null,
    val smallThumbnail: String? = null
) {
    val httpsThumbnail: String?
        get() = (thumbnail ?: smallThumbnail)?.replace("http://", "https://")
}
