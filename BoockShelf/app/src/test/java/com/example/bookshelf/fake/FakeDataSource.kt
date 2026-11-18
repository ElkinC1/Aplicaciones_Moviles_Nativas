package com.example.bookshelf.fake

import com.example.bookshelf.model.Book
import com.example.bookshelf.model.ImageLinks
import com.example.bookshelf.model.VolumeInfo

object FakeDataSource {
    val booksList = listOf(
        Book(
            id = "jazz1",
            volumeInfo = VolumeInfo(
                title = "Jazz: A History of America's Music",
                authors = listOf("Geoffrey C. Ward", "Ken Burns"),
                imageLinks = ImageLinks(
                    thumbnail = "http://books.google.com/books/content?id=jazz1&img=1"
                )
            )
        ),
        Book(
            id = "jazz2",
            volumeInfo = VolumeInfo(
                title = "The Jazz Book: From Ragtime to the 21st Century",
                authors = listOf("Joachim-Ernst Berendt"),
                imageLinks = ImageLinks(
                    thumbnail = "http://books.google.com/books/content?id=jazz2&img=1"
                )
            )
        )
    )
}
