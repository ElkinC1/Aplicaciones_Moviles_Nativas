package com.example.tinyprice.data.remote

import com.example.tinyprice.BuildConfig
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

object TinyPriceApiFactory {

    private val httpClient = OkHttpClient.Builder()
        .connectTimeout(15, TimeUnit.SECONDS)
        .readTimeout(20, TimeUnit.SECONDS)
        .writeTimeout(20, TimeUnit.SECONDS)
        .build()

    private val moshi = Moshi.Builder()
        .addLast(KotlinJsonAdapterFactory())
        .build()

    fun create(): TinyPriceApi = Retrofit.Builder()
        .baseUrl(BuildConfig.EDGE_RUNTIME_BASE_URL.ensureTrailingSlash())
        .client(httpClient)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .build()
        .create(TinyPriceApi::class.java)
}

private fun String.ensureTrailingSlash() =
    if (endsWith('/')) this else "$this/"