package com.example.instagram.mvp.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.instagram.databinding.FragmentHomeBinding
import com.example.instagram.mvp.data.model.Post
import com.example.instagram.mvp.data.model.PostType
import com.example.instagram.mvp.data.model.User
import com.example.instagram.mvp.data.repository.PostRepository
import com.example.instagram.mvp.presenter.PostPresenter
import com.example.instagram.mvp.ui.view.PostView

class HomeFragment : Fragment(), PostView {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var postPresenter: PostPresenter
    private lateinit var postAdapter: PostAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val user = User("1", "pooja", "profile_image")
        postPresenter = PostPresenter(PostRepository(user), this)

        postAdapter = PostAdapter(
            onLikeClick = { post -> postPresenter.likePost(post.postId) },
            onCommentClick = { post -> postPresenter.addComment(post.postId, "New Comment") }
        )

        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = postAdapter
        }

        val newPost = Post (
            postId = System.currentTimeMillis().toString(),
            user = user,
            caption = "New Post",
            type = PostType.IMAGE,
            contentUrl = "url_to_new_image",
            likes = 0,
            comments = emptyList()
        )

        postPresenter.createPost(newPost)
        binding.recyclerView
    }

    override fun displayPosts(posts: List<Post>) {
        postAdapter.submitList(posts)
    }

    override fun showPostCreated(post: Post) {
        Toast.makeText(requireContext(), "Post Created: ${post.postId}", Toast.LENGTH_SHORT).show()
        postPresenter.getPosts() // Refresh posts
    }

    override fun showLikeUpdated(post: Post) {
        Toast.makeText(requireContext(), "Post Liked: ${post.postId}", Toast.LENGTH_SHORT).show()
        postPresenter.getPosts() // Refresh posts
    }

    override fun showCommentAdded(post: Post) {
        Toast.makeText(requireContext(), "Comment Added: ${post.postId}", Toast.LENGTH_SHORT).show()
        postPresenter.getPosts() // Refresh posts
    }

    override fun showError(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }

}