package com.example.instagram

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
//import com.example.instagram.cleanmvvm.ui.home.HomeFragment
import com.example.instagram.mvvm.ui.home.HomeFragment
//import com.example.instagram.mvp.ui.home.HomeFragment


class MainActivity : AppCompatActivity() { //samsung AppCompactActivity() -> custom
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //set up initial fragment
        if (savedInstanceState == null) {
            //ask?
           supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer, HomeFragment()).commit()
        }
    }
}

/*
What it does:
Acts as the entry point for the application and hosts the fragments (like HomeFragment).
Interaction:
It initializes the first fragment (HomeFragment), which is responsible for displaying the user feed.
Why it's needed:
Provides a container (fragmentContainer) for navigating between fragments.

 */