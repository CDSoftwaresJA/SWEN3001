package com.webot.swen3001.ui.report

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.webot.swen3001.MainActivity
import com.webot.swen3001.R
import com.webot.swen3001.ui.SymptomsActivity
import com.webot.swen3001.ui.SymptomsChecklistAdapter
import com.webot.swen3001.ui.SymptomsListAdapter
import kotlinx.android.synthetic.main.fragment_dashboard.*

class ReportFragment : Fragment() {


  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    val rootView = inflater.inflate(R.layout.fragment_dashboard, container, false)

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