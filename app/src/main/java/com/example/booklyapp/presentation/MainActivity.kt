package com.example.booklyapp.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.booklyapp.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.container, MainScreen())
                .commit()
        }

    }
}