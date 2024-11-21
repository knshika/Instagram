package com.example.instagram.mvvm.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.instagram.R
import com.example.instagram.mvvm.data.model.Post
import com.example.instagram.mvvm.data.model.PostType

class PostAdapter(
    private var posts: List<Post>,
    private val listener: PostClickListener
) : RecyclerView.Adapter<PostAdapter.PostViewHolder>() {

    class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val userName = itemView.findViewById<TextView>(R.id.userName)!!
        val content = itemView.findViewById<ImageView>(R.id.postContent)
        val caption = itemView.findViewById<TextView>(R.id.caption)
        val likeBtn = itemView.findViewById<Button>(R.id.likeButton)
        val commentBtn = itemView.findViewById<Button>(R.id.commentButton)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_post, parent, false)
        return PostViewHolder(view)
    }

    override fun getItemCount(): Int {
        return posts.size
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val post = posts[position]
        when (post.type) {
            PostType.IMAGE -> {
//                Glide.with(holder.content.context).load(post.contentUrl).into(holder.content)
            }
            PostType.REEL, PostType.VIDEO -> {

            }
        }
        holder.userName.text = post.user.userName
        holder.caption.text = post.caption
        holder.likeBtn.text = "Likes: ${post.likes}"
        holder.likeBtn.setOnClickListener { listener.onLikeClicked(post.postId)}
        holder.commentBtn.setOnClickListener { listener.onCommentClicked(post.postId)}
    }

    fun updatePosts(newPosts: List<Post>) {
        posts = newPosts
        notifyDataSetChanged()
    }

}

/*
What it does:
Displays a list of posts (each item has images/videos, likes, and comments) inside the RecyclerView.
Key Functions:
onBindViewHolder(): Dynamically binds each post's data (image, video, like count, etc.) to its respective views.
Handles user actions (like click events on the "Like" and "Comment" buttons).
Interaction:
Receives data: Gets a list of posts (posts) from HomeFragment via the constructor.
Sends actions: Uses a listener interface (PostClickListener) to notify HomeFragment when a button is clicked.
 */

/*
onCreateViewHolder: which deals with the inflation of the card layout as an item for the RecyclerView. onBindViewHolder: which
 deals with the setting of different data and methods related to clicks on particular items of the RecyclerView.
 */