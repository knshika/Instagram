package com.example.instagram.mvvm.viewmodel

import androidx.lifecycle.ViewModel
import com.example.instagram.mvvm.data.repository.UserRepository

class UserViewModel() : ViewModel() {
    private val repository = UserRepository()
//    val usersLiveData = repository.getUsers()
    //not required yet as user is 1 and no live data is needed
}