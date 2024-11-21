package com.example.instagram.mvvm.viewmodel

import android.view.View
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.instagram.mvvm.data.repository.PostRepository
import com.example.instagram.mvvm.data.repository.UserRepository

class ViewModelFactory(
    private val postRepository: PostRepository,
    private val userRepository: UserRepository
) : ViewModelProvider.Factory{

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
//        return when {
//            modelClass.isAssignableFrom(PostViewModel::class.java) -> {
//                PostViewModel(postRepository) as T
//            }
//            modelClass.isAssignableFrom(UserViewModel::class.java) -> {
//                UserViewModel(userRepository) as T
//            }
//            else -> throw IllegalArgumentException("Unknown View Model class")
//        }
        return super.create(modelClass)
    }

}