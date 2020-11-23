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
import com.webot.swen3001.utils.AppDatabase
import com.webot.swen3001.R
import com.webot.swen3001.ui.symptoms.SymptomsActivity
import com.webot.swen3001.adapter.SymptomsListAdapter
import com.webot.swen3001.models.SymptomsLog
import kotlin.concurrent.thread

class ReportFragment : Fragment() {


  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    val rootView = inflater.inflate(R.layout.fragment_dashboard, container, false)

    thread {
      var dataList = ArrayList<SymptomsLog>()

      val db = Room.databaseBuilder(
        requireContext(),
        AppDatabase::class.java, "tracer"
      ).build()
      //db.queries().insertAll(SymptomsLog(0,"Test Date","1,0,1,0,1,0,1,0,1,0"))
      val arr =       db.queriesSymptoms().loadSymptomsLogs()
      for (log in arr){
        var data = SymptomsLog(0,log.symptoms, log.date)
        dataList.add(data)
        Log.d("Symptoms: ", "${log.symptoms}")

      }
      requireActivity().runOnUiThread {
        val view:RecyclerView = rootView.findViewById<RecyclerView>(R.id.symptoms_list_recycler_view)
        view.adapter = SymptomsListAdapter(
          dataList
        )
        view.layoutManager = LinearLayoutManager(
          context
        )
        view.setHasFixedSize(true)

      }
    }


    val submitButton = rootView.findViewById<Button>(R.id.add_reportbtn)
    submitButton.setOnClickListener {
      val intent = Intent(requireContext(), SymptomsActivity::class.java)
      startActivity(intent)
    }
    return rootView
  }
}