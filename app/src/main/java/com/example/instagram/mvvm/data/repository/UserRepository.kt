package com.example.instagram.mvvm.data.repository

import androidx.lifecycle.MutableLiveData
import com.example.instagram.mvvm.data.model.User
import java.util.UUID

class UserRepository {
    //ask?
    private val users = mutableListOf<User>()

    fun createUser(username: String, profilePicture: String): User {
        //ask?
        val newUser = User(UUID.randomUUID().toString(), username, profilePicture)
        users.add(newUser)
        return newUser
    }

    fun getUser(userId: String): User? {
        return users.find {it.userId == userId}
    }
}