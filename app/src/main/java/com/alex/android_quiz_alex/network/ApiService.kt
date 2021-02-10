package com.alex.android_quiz_alex.network

import com.alex.android_quiz_alex.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


class ApiService private constructor() {

    companion object {
        private val service: ApiService = ApiService()
        val sp: ApiFunction by lazy { ApiFunction(service.retrofit.create(ApiInterface::class.java)) }
    }

    private val retrofit: Retrofit
    private val baseUrl: String = "https://api.github.com"

    private val logInterceptor =
        HttpLoggingInterceptor().setLevel(if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE)

    private val client: OkHttpClient.Builder
        get() {
            return OkHttpClient.Builder()
                .addInterceptor(logInterceptor)
                .callTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
        }

    init {
        retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client.build())
            .build()
    }
}
