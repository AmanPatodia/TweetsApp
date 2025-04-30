package com.example.tweetsapp.data.repository

import com.example.tweetsapp.models.TweetsListItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers

interface TweetsRepository {

    @GET("v3/b/6809a1ea8561e97a500645da?meta=false")
    suspend fun getTweets(@Header("X-JSON-Path") category : String) : Response<List<TweetsListItem>>

    @GET("v3/b/6809a1ea8561e97a500645da?meta=false")
    @Headers("X-JSON-Path:tweets..category")
    suspend fun getCategories() : Response<List<String>>
}