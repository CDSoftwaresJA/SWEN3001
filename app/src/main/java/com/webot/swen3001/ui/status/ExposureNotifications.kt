package com.webot.swen3001.ui.status

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.webot.swen3001.R
import com.webot.swen3001.utils.Utils
import es.dmoral.toasty.Toasty

class ExposureNotifications : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exposure_notifications)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setTitle("Exposure Notifications")


        //TURN EXPOSURE NOTIFICATIONS ON OR OFF
        val exposureOnBtn = findViewById<Button>(R.id.exposureOn_btn)
        val exposureOffBtn = findViewById<Button>(R.id.exposureOff_btn)


        exposureOnBtn.setOnClickListener {
            Utils.updateNotification(1)
            Toasty.success(this, "Exposure Notifications Are Now On", Toast.LENGTH_SHORT).show()
            finish()
        }

        exposureOffBtn.setOnClickListener {
            Utils.updateNotification(0)
            Toasty.error(this, "Exposure Notifications Are Now Off", Toast.LENGTH_SHORT).show()
            finish()
        }



    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return super.onSupportNavigateUp()
    }
}