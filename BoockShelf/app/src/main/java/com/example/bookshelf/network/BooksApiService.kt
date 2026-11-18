package com.example.bookshelf.network

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.example.bookshelf.model.BookResponse
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Query

private const val BASE_URL = "https://www.googleapis.com/books/v1/"

private val json = Json { ignoreUnknownKeys = true }

interface BooksApiService {
    @GET("volumes")
    suspend fun getBooks(@Query("q") query: String = "kotlin"): BookResponse
}

object BooksApi {
    val retrofitService: BooksApiService by lazy {
        Retrofit.Builder()
            .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
            .baseUrl(BASE_URL)
            .build()
            .create(BooksApiService::class.java)
    }
}