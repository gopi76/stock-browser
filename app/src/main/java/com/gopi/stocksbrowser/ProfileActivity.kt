package com.gopi.stocksbrowser

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class ProfileActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val back2home: Button = findViewById(R.id.back2home)
        back2home.setOnClickListener {
            val intent333 = Intent(this, MainPageActivity::class.java)
            startActivity(intent333)
            finish()
        }
    }
}