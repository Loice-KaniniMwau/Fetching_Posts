package com.example.fetchingposts.model

import androidx.lifecycle.MutableLiveData

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fetchingposts.repository.PostsRepository
import kotlinx.coroutines.launch

class PostsViewModel:ViewModel (){
    var postsrepo= PostsRepository()
        var postsLiveData= MutableLiveData<List<Posts>>()
        var errorLiveData= MutableLiveData<String>()

  suspend fun fetchProducts(){
        viewModelScope.launch{
            val response=postsrepo.getPosts()
            if(response.isSuccessful){
                postsLiveData.postValue(response.body()?.posts)
            }
            else{
                errorLiveData.postValue(response.errorBody()?.string())
            }
        }
    }
    }


