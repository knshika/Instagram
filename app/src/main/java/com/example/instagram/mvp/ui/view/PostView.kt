package com.example.instagram.mvp.ui.view

import com.example.instagram.mvp.data.model.Post

interface PostView {
    fun displayPosts(posts: List<Post>)
    fun showPostCreated(post: Post)
    fun showLikeUpdated(post: Post)
    fun showCommentAdded(post: Post)
    fun showError(message: String)
}