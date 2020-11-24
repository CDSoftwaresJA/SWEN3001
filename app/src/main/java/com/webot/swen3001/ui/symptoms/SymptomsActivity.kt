package com.webot.swen3001.ui.symptoms

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.room.Room
import com.webot.swen3001.MainActivity
import com.webot.swen3001.R
import com.webot.swen3001.adapter.SymptomsChecklistAdapter
import com.webot.swen3001.models.SymptomsLog
import com.webot.swen3001.utils.AppDatabase
import kotlinx.android.synthetic.main.activity_symptoms.*
import java.text.SimpleDateFormat
import java.util.*
import kotlin.concurrent.thread

class SymptomsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_symptoms)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)

        val listView = symptoms_checklist_list_view
        val adapter = SymptomsChecklistAdapter(this)
        val db = Room.databaseBuilder(
            baseContext,
            AppDatabase::class.java, "tracer"
        ).build()

        listView.adapter = adapter
        val submitButton = findViewById<Button>(R.id.submitButton)
        submitButton.setOnClickListener {
            var parseString:String = ""
            var i:Int=0
            for (state in SymptomsChecklistAdapter.checkBoxListState){
                i++
                if (state){
                    parseString+= SymptomsChecklistAdapter.symptomsList.get(i-1) +", "
                }
            }
            val sdf = SimpleDateFormat("dd/M/yyyy hh:mm:ss")
            val currentDate = sdf.format(Date())
            if (parseString.isEmpty()){
                parseString="No Symptoms"
            }
            thread {
                db.queriesSymptoms().insertSymptomsLogs(SymptomsLog(0,currentDate,parseString))

            }

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }



    override fun onSupportNavigateUp(): Boolean {
        finish()
        return super.onSupportNavigateUp()
    }


}