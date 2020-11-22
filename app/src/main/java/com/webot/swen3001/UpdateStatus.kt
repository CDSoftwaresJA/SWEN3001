package com.webot.swen3001

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.webot.swen3001.Utils.updateStatus
import com.webot.swen3001.ui.profile.ProfileViewModel
import es.dmoral.toasty.Toasty
import kotlinx.android.synthetic.main.fragment_notifications.*

class UpdateStatus : AppCompatActivity() {

    // var fragment = supportFragmentManager.findFragmentById(R.id.navigation_notifications)
    // private lateinit var viewModel: ProfileViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_status)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setTitle("Update Status")

        // viewModel = ViewModelProvider(this).get(ProfileViewModel::class.java)

        //CHANGE THE USERS STATUS TO POSITIVE OR NEGATIVE
        val positive_btn = findViewById<Button>(R.id.positivebtn)
        val negative_btn = findViewById<Button>(R.id.negativebtn)


        positive_btn.setOnClickListener {
            updateStatus("1")
            Toasty.success(this, "Status changed to Positive", Toast.LENGTH_SHORT).show()
            finish()
            }

        negative_btn.setOnClickListener {
            updateStatus("0")
            Toasty.error(this, "Status changed to Negative", Toast.LENGTH_SHORT).show()
            finish()
            }
    }
}