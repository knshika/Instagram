package com.example.instagram.mvp.data.model

import com.example.instagram.mvp.data.model.User

data class Post(
    val postId: String,
    val user: User,
    val contentUrl: String,
    val type: PostType,
    val caption: String,
    var likes: Int,
    var comments: List<String>
)

enum class PostType {
    IMAGE, VIDEO, REEL
}