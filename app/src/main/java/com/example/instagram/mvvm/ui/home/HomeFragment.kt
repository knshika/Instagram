package com.example.instagram.mvvm.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.instagram.R
import com.example.instagram.mvvm.viewmodel.PostViewModel

class HomeFragment : Fragment() {
    private lateinit var postAdapter: PostAdapter
    private val postViewModel: PostViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        return super.onCreateView(inflater, container, savedInstanceState)
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)

        recyclerView.layoutManager = LinearLayoutManager(context)
        postAdapter = PostAdapter(emptyList(), object : PostClickListener {
            override fun onLikeClicked(postId: String) {
                postViewModel.likePost(postId)
            }

            override fun onCommentClicked(postId: String) {
                postViewModel.addComment(postId, "Sample comment")
            }
        })

        recyclerView.adapter = postAdapter
        postViewModel.postLiveData.observe(viewLifecycleOwner) {
            posts -> postAdapter.updatePosts(posts)
        }
        return view
    }

//    Adapter
//    An adapter is a hardware component that allows a device with one plug to connect to a different
//    jack on a computer. For example, a USB adapter allows a device with a USB port to connect to a device with a different type of port.
//    RecyclerView
//    A RecyclerView is a way to display data in a scrolling list or grid format in Android applications.
//    It uses the adapter pattern to connect data with list item views.
//    To implement a RecyclerView, you need to create an adapter and a ViewHolder. The adapter connects
//    the RecyclerView and its data via the view holder. The adapter converts the data into a format that can be displayed in a list or grid format.
//    The view holder represents each item in the collection and displays it.
}

/*
What it does:
Displays the user feed (a list of posts).
Key Functions:
Initializes RecyclerView and its adapter (PostAdapter).
Observes data from PostViewModel using LiveData.
Passes user actions (like clicks on "Like" or "Comment") to the ViewModel.
Interaction:
Receives data: Observes postsLiveData from PostViewModel.
Sends actions: Calls functions like likePost() or addComment() in PostViewModel.
 */