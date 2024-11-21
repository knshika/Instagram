package com.example.instagram.mvvm.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.instagram.mvvm.data.model.Post
import com.example.instagram.mvvm.data.model.PostType
import com.example.instagram.mvvm.data.model.User
import java.util.UUID

class PostRepository {
    private val posts = MutableLiveData<List<Post>>()

    fun getPosts(): LiveData<List<Post>> {
        return posts
    }

    fun createPost(user: User, contentUrl: String, type: PostType, caption: String) {
        val newPost = Post(
            postId = UUID.randomUUID().toString(),
            user = user,
            contentUrl = contentUrl,
            type = type,
            likes = 0,
            caption = caption,
            comments = emptyList()
        )
        //ask?
        posts.value = posts.value.orEmpty() + newPost
    }

    fun likePost(postId: String) {
        posts.value = posts.value?.map {
            if(it.postId == postId) it.copy(likes =  it.likes + 1) else it
        }
    }

    fun addComment(postId: String, comment: String) {
        posts.value = posts.value?.map {
            if(it.postId == postId) it.copy(comments = it.comments + comment) else it
        }
    }
}

/*
What it does:
Provides access to the data source (in-memory list, API, or database) and handles all data-related operations.

Interaction:
Receives actions: From PostViewModel (like creating a post or liking a post).
Sends data: Updates the LiveData object (postsLiveData), which triggers changes in the ViewModel and ultimately updates the UI.
 */

