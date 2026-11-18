package com.example.bookshelf.data

import com.example.bookshelf.model.Book
import com.example.bookshelf.network.BooksApi

interface BooksRepository {
    suspend fun getBooks(): List<Book>
}

class NetworkBooksRepository : BooksRepository {
    override suspend fun getBooks(): List<Book> {
        return BooksApi.retrofitService.getBooks().items
    }
}