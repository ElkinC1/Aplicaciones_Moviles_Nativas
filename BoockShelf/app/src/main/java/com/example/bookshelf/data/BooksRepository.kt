package com.example.bookshelf.data

import com.example.bookshelf.BuildConfig
import com.example.bookshelf.model.Book
import com.example.bookshelf.network.BooksApiService

interface BooksRepository {
    suspend fun getBooks(query: String = "jazz"): List<Book>
}

class NetworkBooksRepository(
    private val booksApiService: BooksApiService
) : BooksRepository {
    override suspend fun getBooks(query: String): List<Book> {
        val apiKey = BuildConfig.BOOKS_API_KEY.ifEmpty { null }
        return booksApiService.getBooks(query = query, apiKey = apiKey).items ?: emptyList()
    }
}
