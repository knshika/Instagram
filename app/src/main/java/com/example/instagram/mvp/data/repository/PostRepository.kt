package com.example.instagram.mvp.data.repository

import com.example.instagram.mvp.data.model.Post
import com.example.instagram.mvp.data.model.PostType

class PostRepository(user: com.example.instagram.mvp.data.model.User) {
    private val posts = mutableListOf(
        Post("1", user,"url_to_image", PostType.IMAGE, "",100, listOf("Nice pic!", "Great shot!")),
        Post("2", user,"url_to_video", PostType.VIDEO, "",10, listOf("Nice pic!", "Great shot!")),
        )

    fun getPosts(): List<Post> {
        return posts
    }

    fun addPost(post: Post) {
        posts.add(post)
    }

    fun likePost(postId: String): Post? {
        val post = posts.find { it.postId == postId }
        post?.let {
            val updatedPost = it.copy(likes = it.likes + 1)
            posts[posts.indexOf(it)] = updatedPost
            return updatedPost
        }
        return null
    }

    fun addComment(postId: String, comment: String): Post? {
        val post = posts.find { it.postId == postId }
        post?.let {
            val updatedPost = it.copy(comments = it.comments + comment)
            posts[posts.indexOf(it)] = updatedPost
            return updatedPost
        }
        return null
    }
}