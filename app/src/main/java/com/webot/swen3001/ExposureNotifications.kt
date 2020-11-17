package com.webot.swen3001

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import es.dmoral.toasty.Toasty

class ExposureNotifications : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exposure_notifications)


        //TURN EXPOSURE NOTIFICATIONS ON OR OFF
        val exposureOnBtn = findViewById<Button>(R.id.exposureOn_btn)
        val exposureOffBtn = findViewById<Button>(R.id.exposureOff_btn)


        exposureOnBtn.setOnClickListener {
            Utils.updateNotification(1)
            Toasty.success(this, "Exposure Notifications Are Now On", Toast.LENGTH_SHORT).show()
        }

        exposureOffBtn.setOnClickListener {
            Utils.updateNotification(0)
            Toasty.success(this, "Exposure Notifications Are Now Off", Toast.LENGTH_SHORT).show()
        }
    }
}