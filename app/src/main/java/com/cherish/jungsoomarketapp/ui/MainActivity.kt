package com.cherish.jungsoomarketapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.cherish.jungsoomarketapp.R

class MainActivity : AppCompatActivity() {
    private val mainFragment = MainFragment()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction().replace(R.id.fragmentLayout, mainFragment)
            .commit()


    }
}
