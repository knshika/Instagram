package com.example.instagram.mvvm.ui.home

interface PostClickListener {
    fun onLikeClicked(postId: String)
    fun onCommentClicked(postId: String)
}