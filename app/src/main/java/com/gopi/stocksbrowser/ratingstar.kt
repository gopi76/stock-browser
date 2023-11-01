package com.gopi.stocksbrowser

import android.Manifest
import android.annotation.SuppressLint
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

class ratingstar : AppCompatActivity() {


    private val CHANNEL_ID = "Channel_id_example_1"
    private val notificationid = 101

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ratingstar)


        createNotificationChannel()

        val rt: RatingBar = findViewById(R.id.ratingBar)
        val txtview: TextView = findViewById(R.id.textxviewrating)
        val submit: Button = findViewById(R.id.button)

        var emoji: ImageView = findViewById(R.id.emoji)

        rt.onRatingBarChangeListener =
            RatingBar.OnRatingBarChangeListener { _, _, _ -> // Do something when the rating changes
                val rate = rt.rating
                if (rate <= 1) {
                    emoji.setImageResource(R.drawable.sad)
                } else if (rate <= 2) {
                    emoji.setImageResource(R.drawable.worried)
                } else if (rate <= 3) {
                    emoji.setImageResource(R.drawable.nuetral)
                } else if (rate <= 4) {
                    emoji.setImageResource(R.drawable.happy)
                } else {
                    emoji.setImageResource(R.drawable.sattisfied)
                }

                submit.setOnClickListener {
                    txtview.text = rt.rating.toString()
                    Toast.makeText(this, "Selected Rating: ${rt.rating}", Toast.LENGTH_SHORT).show()

                    sendNotification()
                }
            }
    }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = "Notification"
            val descriptionText = "Notification Description"
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(CHANNEL_ID,name, importance).apply {
                description = descriptionText
            }
            val notificationManager:NotificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }

    private fun sendNotification() {
        val builder = NotificationCompat.Builder(this, CHANNEL_ID)
            .setSmallIcon(R.drawable.baseline_circle_notifications_24)
            .setContentTitle("Notification")
            .setContentText("You have successfully given rating for this app")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)

        with(NotificationManagerCompat.from(this)) {
            notify(notificationid, builder.build())
        }




    }
}


