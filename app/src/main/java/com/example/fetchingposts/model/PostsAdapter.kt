package com.example.fetchingposts.model

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fetchingposts.databinding.PostsListsBinding

class PostsAdapter (var postsLists:List<Posts>):RecyclerView.Adapter<PostsViewHolder>(){
    lateinit var binding: PostsListsBinding
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostsViewHolder {
        val binding=PostsListsBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return PostsViewHolder(binding)

    }

    override fun getItemCount(): Int {
     return postsLists.size
    }

    override fun onBindViewHolder(holder: PostsViewHolder, position: Int) {
        val currentPost=postsLists[position]
        val binding=holder.binding
        binding.tvUserId.text=currentPost.userId.toString()
        binding.tvId.text=currentPost.id.toString()
        binding.tvTitle.text=currentPost.title.toString()
        binding.tvBody.text=currentPost.body.toString()

    }
    }


class PostsViewHolder(var binding: PostsListsBinding):RecyclerView.ViewHolder(binding.root)






