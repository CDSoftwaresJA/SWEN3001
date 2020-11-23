package com.webot.swen3001.ui.status

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.webot.swen3001.R
import com.webot.swen3001.utils.Utils.updateStatus
import es.dmoral.toasty.Toasty

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