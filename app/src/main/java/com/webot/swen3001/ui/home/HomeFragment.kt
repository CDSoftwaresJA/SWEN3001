package com.webot.swen3001.ui.home

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import com.webot.swen3001.R
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {


  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    val rootView: View = inflater.inflate(R.layout.fragment_home, container, false)

    //Adding event listener to the first card of the home screen
    val dial119Card: View = rootView.findViewById(R.id.dial119Card)
    dial119Card.setOnClickListener {
      val dialIntent = Intent(Intent.ACTION_DIAL)
      dialIntent.data = Uri.parse("tel:119")
      startActivity(dialIntent)
    }

    val requestTestCard: View = rootView.findViewById(R.id.requestTestCard)
    requestTestCard.setOnClickListener {
      val requestTestIntent = Intent(Intent.ACTION_VIEW)
      val url: String = "https://jamcovid19.moh.gov.jm/report-yourself.html"
      requestTestIntent.data = Uri.parse(url)
      startActivity(requestTestIntent)
    }

    return rootView

  }
}