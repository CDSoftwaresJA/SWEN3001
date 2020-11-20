package com.webot.swen3001.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import com.webot.swen3001.MainActivity
import com.webot.swen3001.R
import kotlinx.android.synthetic.main.activity_symptoms.*

class SymptomsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_symptoms)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)

        symptoms_checklist_list_view.adapter = SymptomsChecklistAdapter(this)
//        symptoms_checklist_list_view.onItemClickListener
//        symptoms_checklist_recycler_view.layoutManager = LinearLayoutManager(this)
//        symptoms_checklist_recycler_view.setHasFixedSize(true)

        val submitButton = findViewById<Button>(R.id.submitButton)
        submitButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }



    override fun onSupportNavigateUp(): Boolean {
        finish()
        return super.onSupportNavigateUp()
    }


}