package com.example.instagram.mvp.ui.home

interface PostClickListener {
    fun onLikeClicked(postId: String)
    fun onCommentClicked(postId: String)
}