package com.gopi.stocksbrowser


import android.annotation.SuppressLint
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.widget.EditText
import android.widget.RemoteViews
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class FeedbackForm : AppCompatActivity() {

    private lateinit var editTextName: EditText
    private lateinit var editTextPhone: EditText
    private lateinit var editTextQuery: EditText
    private lateinit var editTextEmail: EditText
    private lateinit var btnSubmit: Button

    private lateinit var loadingDialog: DialogHelper


    // Reference to the Firebase Realtime Database
    private lateinit var databaseReference: DatabaseReference

    lateinit var notificationManager: NotificationManager
    lateinit var notificationChannel: NotificationChannel
    lateinit var builder: Notification.Builder
    private val channelId = "i.apps.notifications"
    private val description = "Test notification"

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feedback_form)

        editTextName = findViewById(R.id.editTextName)
        editTextPhone = findViewById(R.id.editTextPhone)
        editTextQuery = findViewById(R.id.editTextQuery)
        btnSubmit = findViewById(R.id.btnSubmit)
        editTextEmail = findViewById(R.id.editTextEmail)

        // Initialize the Firebase Database reference
        databaseReference = FirebaseDatabase.getInstance().reference.child("contactInfo")

        // Set onClickListener for btnSubmit

        val loadingdialog = DialogHelper(this)
        btnSubmit.setOnClickListener {
            onSubmitClick(it)
            loadingdialog.startLoadingdialog()

            val handler = Handler()
            handler.postDelayed({
                loadingdialog.dismissdialog()
                val i = Intent(this@FeedbackForm, finished::class.java)
                startActivity(i)
            }, 4000)

        }

        val resetBtn: Button = findViewById(R.id.btnReset)
        resetBtn.setOnClickListener {
            editTextName.text.clear()
            editTextEmail.text.clear()
            editTextPhone.text.clear()
            editTextQuery.text.clear()
        }

    }



    fun onSubmitClick(view: android.view.View) {
        val name = editTextName.text.toString()
        val phone = editTextPhone.text.toString()
        val query = editTextQuery.text.toString()
        val email = editTextEmail.text.toString()

        // Create a unique key for each submission
        val submissionKey = databaseReference.push().key

        // Create a ContactInfo object
        val contactInfo = ContactInfo(name, phone, email, query)

        // Store the contact information in the Firebase Realtime Database
        if (submissionKey != null) {
            databaseReference.child(submissionKey).setValue(contactInfo)
        }

        // Display a toast message for successful submission
        Toast.makeText(this, "Successfully submitted your query", Toast.LENGTH_SHORT).show()

        // Create and display a notification



    }





}
