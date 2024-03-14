package com.example.projekkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class AboutPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_page)

        val profileImage = findViewById<ImageView>(R.id.profile_image)
        val nameTextView = findViewById<TextView>(R.id.name_textview)
        val emailTextView = findViewById<TextView>(R.id.email_textview)

        profileImage.setImageResource(R.drawable.katherine_febrianty_sumartono)
        nameTextView.text = getString(R.string.nama)
        emailTextView.text = getString(R.string.email)
    }
}