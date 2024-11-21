package com.example.instagram.mvvm.data.model

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

/*
What they do:
Define the structure of objects like Post and User. They represent the data model.
Key Classes:
Post: Represents a single post in the feed.
User: Represents a user in the app.
Interaction:
Passed between layers (e.g., PostRepository -> PostViewModel -> HomeFragment).
 */