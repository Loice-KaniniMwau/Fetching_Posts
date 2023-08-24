package com.example.fetchingposts.repository

import com.example.fetchingposts.api.ApiClient
import com.example.fetchingposts.api.ApiInterface
import com.example.fetchingposts.model.Posts
import com.example.fetchingposts.model.PostsResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class PostsRepository {


    val apiClient= ApiClient.buildClient(ApiInterface::class.java)
    suspend fun getPosts(): Response<List<Posts>> {
        return withContext(Dispatchers.IO){
            apiClient.getPosts()
        }
    }
}