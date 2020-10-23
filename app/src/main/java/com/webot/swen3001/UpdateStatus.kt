package com.webot.swen3001

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.webot.swen3001.ui.profile.ProfileFragment
import es.dmoral.toasty.Toasty
import kotlinx.android.synthetic.main.fragment_notifications.*
import org.w3c.dom.Text

class UpdateStatus : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_status)


        //change the users status to positive or negative
        val positive_btn = findViewById<Button>(R.id.positivebtn)
        val negative_btn = findViewById<Button>(R.id.negativebtn)


        positive_btn.setOnClickListener {
            Toasty.success(this, "Status changed to Positive", Toast.LENGTH_SHORT).show()

            }

        negative_btn.setOnClickListener {
            Toasty.success(this, "Status changed to Negative", Toast.LENGTH_SHORT).show()
            }

    }
}