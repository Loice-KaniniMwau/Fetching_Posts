package com.example.fetchingposts
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager

import com.example.fetchingposts.databinding.ActivityMainBinding

import com.example.fetchingposts.model.PostsAdapter
import com.example.fetchingposts.model.PostsViewModel


class MainActivity : AppCompatActivity() {
    val postsViewModel: PostsViewModel by viewModels()
    lateinit var binding: ActivityMainBinding
    lateinit var postsAdapter: PostsAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }

    override fun onResume() {
        super.onResume()


        postsViewModel.fetchPosts()

        postsViewModel.postsLiveData.observe(
            this,
            Observer { postsList ->
                val postsAdapter = PostsAdapter(postsList ?: emptyList())
                binding.rvPosts.layoutManager = GridLayoutManager(this@MainActivity, 2)
                binding.rvPosts.adapter = postsAdapter
            })

        postsViewModel.errorLiveData.observe(this, Observer { error ->
            Toast.makeText(baseContext, error, Toast.LENGTH_LONG).show()
        })


    }
}



