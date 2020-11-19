package com.webot.swen3001.ui.report

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.webot.swen3001.AppDatabase
import com.webot.swen3001.R
import com.webot.swen3001.ui.SymptomsActivity
import com.webot.swen3001.ui.SymptomsListAdapter
import kotlin.concurrent.thread

class ReportFragment : Fragment() {


  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    val rootView = inflater.inflate(R.layout.fragment_dashboard, container, false)

    thread {
      val db = Room.databaseBuilder(
        requireContext(),
        AppDatabase::class.java, "tracer"
      ).build()
      //db.queries().insertAll(SymptomsLog(0,"Test Date","1,0,1,0,1,0,1,0,1,0"))
      val arr =       db.queries().loadLogs()
      for (log in arr){
        Log.d("Symptoms: ","${log.symptoms}")
      }


    }



    rootView.findViewById<RecyclerView>(R.id.symptoms_list_recycler_view).adapter = SymptomsListAdapter()
    rootView.findViewById<RecyclerView>(R.id.symptoms_list_recycler_view).layoutManager = LinearLayoutManager(context)
    rootView.findViewById<RecyclerView>(R.id.symptoms_list_recycler_view).setHasFixedSize(true)

    val submitButton = rootView.findViewById<Button>(R.id.add_reportbtn)
    submitButton.setOnClickListener {
      val intent = Intent(requireContext(), SymptomsActivity::class.java)
      startActivity(intent)
    }
    return rootView
  }
}