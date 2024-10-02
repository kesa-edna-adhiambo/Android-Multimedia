package com.kesa.multimedia.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kesa.multimedia.R
import com.kesa.multimedia.databinding.ActivityHomeBinding

class Home : AppCompatActivity() {

    lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_home)
    }
}