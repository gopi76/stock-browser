package com.gopi.stocksbrowser

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.view.WindowManager
import android.widget.Button
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.Switch
import android.widget.TextView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatDelegate
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.navigation.NavigationView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth


import com.google.firebase.ktx.Firebase

class MainPageActivity : AppCompatActivity() {

    private lateinit var mGoogleSignInClient: GoogleSignInClient
    private lateinit var mAuth: FirebaseAuth


    lateinit var toggle: ActionBarDrawerToggle

    private lateinit var fabMenu: FloatingActionButton
    private lateinit var subMenuLayout: LinearLayout

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_page)

        mAuth = FirebaseAuth.getInstance()

        /*val feedback:Button = findViewById(R.id.feedback_button)
        feedback.setOnClickListener {
            val intent11 = Intent(this, FeedbackForm::class.java)
            startActivity(intent11)
        }

        val ratingbtn:Button = findViewById(R.id.ratingApp)
        ratingbtn.setOnClickListener {
            val intent22 = Intent(this, ratingstar::class.java)
            startActivity(intent22)
        }


        val stockbtn :Button = findViewById(R.id.stocklive)
        stockbtn.setOnClickListener {
            //setProgressDialog()
            val intent33 = Intent(this, MainActivity::class.java)
            startActivity(intent33)
        }*/

        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()

        mGoogleSignInClient = GoogleSignIn.getClient(this, gso)


        //val textView = findViewById<TextView>(R.id.name)

        val auth = Firebase.auth
        val user = auth.currentUser

        if (user != null) {
            val userName = "Gopi Krishna"
            //textView.text = "Welcome, $userName"
        } else {
            // Handle the case where the user is not signed in
        }


// Inside onCreate() method
        /*
        val signOutButton = findViewById<Button>(R.id.logout_button)
        signOutButton.setOnClickListener {
            val builder = AlertDialog.Builder(this)

            builder.setTitle("Logout")
            builder.setMessage("Are you sure you want to logout?")

            builder.setPositiveButton("Yes") { _, _ ->
                signOutAndStartSignInActivity()
            }

            builder.setNegativeButton("No") { dialog, _ ->
                dialog.dismiss()
            }

            val dialog: AlertDialog = builder.create()
            dialog.show()
        } */

        val drawerLayout: DrawerLayout = findViewById(R.id.my_drawer_layout)
        val navView : NavigationView = findViewById(R.id.navview)

        toggle = ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        navView.setNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.nav_account -> {
                    val intent = Intent(this, ProfileActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.nav_ratings -> {
                    val intent = Intent(this, ratingstar::class.java)
                    startActivity(intent)
                    true
                }
                R.id.nav_feedback -> {
                    val intent = Intent(this, FeedbackForm::class.java)
                    startActivity(intent)
                    true
                }
                R.id.nav_exit -> {
                    finish()
                    true
                }
                R.id.nav_stock -> {
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.nav_logout -> {
                    val builder = AlertDialog.Builder(this)

                    builder.setTitle("Logout")
                    builder.setMessage("Are you sure you want to logout?")

                    builder.setPositiveButton("Yes") { _, _ ->
                        signOutAndStartSignInActivity()
                    }

                    builder.setNegativeButton("No") { dialog, _ ->
                        dialog.dismiss()
                    }

                    val dialog: AlertDialog = builder.create()
                    dialog.show()
                    true
                }


                else -> {
                    false
                }
            }
        }
        fabMenu = findViewById(R.id.fabMenu)
        subMenuLayout = findViewById(R.id.subMenuLayout)

        fabMenu.setOnClickListener {
            toggleSubMenu()
        }

        val btn = findViewById<Switch>(R.id.switch1)

        // set the switch to listen on checked change
        btn.setOnCheckedChangeListener { _, isChecked ->

            // if the button is checked, i.e., towards the right or enabled
            // enable dark mode, change the text to disable dark mode
            // else keep the switch text to enable dark mode
            if (btn.isChecked) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                btn.text = "Disable dark mode"
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                btn.text = "Enable dark mode"
            }
        }



    }


    private fun toggleSubMenu() {
        if (subMenuLayout.visibility == View.VISIBLE) {
            subMenuLayout.visibility = View.GONE
        } else {
            subMenuLayout.visibility = View.VISIBLE
        }
    }
    fun onCallButtonClick(view: View) {
        val phoneNumber = "+91 7659046696"
        openPhoneDialer(phoneNumber)
    }

    fun onMapButtonClick(view: View) {
        val location = "LPU"
        openMap(location)
    }

    fun onWebsiteButtonClick(view: View) {
        val websiteUrl = "https://www.moneycontrol.com/stocksmarketsindia/"
        openWebsite(websiteUrl)
    }

    fun openMap(location: String) {
        val intent = Intent(Intent.ACTION_VIEW)
        val uri = Uri.parse("geo:0,0?q=$location")
        intent.data = uri
        startActivity(intent)
    }

    fun openPhoneDialer(phoneNumber: String) {
        val intent = Intent(Intent.ACTION_DIAL)
        val uri = Uri.parse("tel:$phoneNumber")
        intent.data = uri
        startActivity(intent)
    }


    fun openWebsite(url: String) {
        val intent = Intent(Intent.ACTION_VIEW)
        val uri = Uri.parse(url)
        intent.data = uri
        startActivity(intent)
    }
    // override the onOptionsItemSelected()
    // function to implement
    // the item click listener callback
    // to open and close the navigation
    // drawer when the icon is clicked
    /*override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            true
        } else super.onOptionsItemSelected(item)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_account -> {
                val intent = Intent(this, FeedbackForm::class.java)
                startActivity(intent)
                return true
            }
            R.id.nav_ratings -> {
                val intent = Intent(this, ratingstar::class.java)
                startActivity(intent)
                return true
            }
            R.id.nav_stock -> {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }*/






    private fun signOutAndStartSignInActivity() {
        mAuth.signOut()

        mGoogleSignInClient.signOut().addOnCompleteListener(this) {
            // Optional: Update UI or show a message to the user
            val intent = Intent(this@MainPageActivity, SignInActivity::class.java)
            startActivity(intent)
            finish()

        }
    }
}

      