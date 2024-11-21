package com.example.instagram.mvvm.viewmodel

import androidx.lifecycle.ViewModel
import com.example.instagram.mvvm.data.model.PostType
import com.example.instagram.mvvm.data.model.User
import com.example.instagram.mvvm.data.repository.PostRepository

class PostViewModel : ViewModel() {
    private val repository = PostRepository()
    val postLiveData = repository.getPosts()

    fun createPost(user: User, contentUrl: String, type: PostType, caption: String) {
        repository.createPost(user, contentUrl, type, caption)
    }

    fun likePost(postId: String) {
        repository.likePost(postId)
    }

    fun addComment(postId: String, comment: String){
        repository.addComment(postId, comment)
    }
}

/*
What it does:
Acts as a mediator between the HomeFragment (View) and PostRepository (Model). Manages the feed data and provides it to the View.
Interaction:
Receives actions: Gets user actions (like or comment) from HomeFragment.
Sends data: Updates postsLiveData, which HomeFragment observes.
 */