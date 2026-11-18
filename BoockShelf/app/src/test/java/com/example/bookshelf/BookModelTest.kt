package com.example.bookshelf

import com.example.bookshelf.model.ImageLinks
import org.junit.Assert.assertEquals
import org.junit.Test

class BookModelTest {

    @Test
    fun imageLinks_httpsThumbnail_replacesHttpWithHttps() {
        val imageLinks = ImageLinks(
            thumbnail = "http://books.google.com/books/content?id=jazz123&img=1"
        )
        assertEquals(
            "https://books.google.com/books/content?id=jazz123&img=1",
            imageLinks.httpsThumbnail
        )
    }
}
