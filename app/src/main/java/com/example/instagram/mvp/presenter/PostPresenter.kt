package com.example.instagram.mvp.presenter

import com.example.instagram.mvp.data.repository.PostRepository
import com.example.instagram.mvp.data.model.Post
import com.example.instagram.mvp.ui.view.PostView

class PostPresenter(private val postRepository: PostRepository, private val postView: PostView) {
    fun getPosts() {
        val posts = postRepository.getPosts()
        if (posts.isNotEmpty()){
            postView.displayPosts(posts)
        } else {
            postView.showError("No posts found")
        }
    }

    fun createPost(post: Post) {
        postRepository.addPost(post)
        postView.showPostCreated(post)
    }

    fun likePost(postId: String) {
        val updatedPost = postRepository.likePost(postId)
        if (updatedPost != null) {
            postView.showPostCreated(updatedPost)
        } else {
            postView.showError("Failed to like post")
        }
    }

    fun addComment(postId: String, comment: String) {
        val updatedPost = postRepository.addComment(postId, comment)
        if (updatedPost != null) {
            postView.showCommentAdded(updatedPost)
        } else {
            postView.showError("Failed to add comment")
        }
    }
}