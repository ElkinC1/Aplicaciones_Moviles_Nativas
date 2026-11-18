package com.example.bookshelf.model

import kotlinx.serialization.Serializable

@Serializable
data class BookResponse(
    val items: List<Book> = listOf()
)

@Serializable
data class Book(
    val id: String,
    val volumeInfo: VolumeInfo
)

@Serializable
data class VolumeInfo(
    val title: String,
    val authors: List<String>? = null,
    val imageLinks: ImageLinks? = null
)

@Serializable
data class ImageLinks(
    val thumbnail: String
)