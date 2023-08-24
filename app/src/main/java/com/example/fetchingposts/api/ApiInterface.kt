package com.example.fetchingposts.api

import com.example.fetchingposts.model.Posts
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {
    @GET("/posts")
    suspend fun getPosts(): Response<List<Posts>>
}