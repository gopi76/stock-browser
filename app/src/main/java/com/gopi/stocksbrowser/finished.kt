package com.gopi.stocksbrowser


import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class finished : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finished)

        val backfeedback: Button = findViewById(R.id.btnbackfeedback)
        val btnhome: Button = findViewById(R.id.btnbackhome)

        backfeedback.setOnClickListener {
            val intent111 = Intent(this,FeedbackForm::class.java)
            startActivity(intent111)
            finish()
        }

        btnhome.setOnClickListener {
            val intent222 = Intent(this,MainPageActivity::class.java)
            startActivity(intent222)
            finish()
        }

    }
}


