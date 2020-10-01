package com.webot.swen3001.ui.report

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.webot.swen3001.R

class ReportFragment : Fragment() {

  private lateinit var reportViewModel: ReportViewModel

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    reportViewModel =
    ViewModelProviders.of(this).get(ReportViewModel::class.java)
    val root = inflater.inflate(R.layout.fragment_dashboard, container, false)
    reportViewModel.text.observe(viewLifecycleOwner, Observer {
    })
    return root
  }
}