package com.webot.swen3001.ui.home

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.android.material.switchmaterial.SwitchMaterial
import com.webot.swen3001.Exposure
import com.webot.swen3001.R
import es.dmoral.toasty.Toasty

class HomeFragment : Fragment() {


  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    val rootView: View = inflater.inflate(R.layout.fragment_home, container, false)
    val exposure:Exposure = Exposure()

    //Adding event listener to the first card of the home screen
    val dial119Card: View = rootView.findViewById(R.id.dial119Card)
    dial119Card.setOnClickListener {
      val dialIntent = Intent(Intent.ACTION_DIAL)
      dialIntent.data = Uri.parse("tel:119")
      startActivity(dialIntent)
    }

    //Adding event listener to the second card of the home screen
    val requestTestCard: View = rootView.findViewById(R.id.requestTestCard)
    requestTestCard.setOnClickListener {
      val requestTestIntent = Intent(Intent.ACTION_VIEW)
      val url = "https://jamcovid19.moh.gov.jm/report-yourself.html"
      requestTestIntent.data = Uri.parse(url)
      startActivity(requestTestIntent)
    }

    //Adding event listener to the third card of the home screen
    val cdcGuidelinesCard: View = rootView.findViewById(R.id.cdcGuidelinesCard)
    cdcGuidelinesCard.setOnClickListener {
      val cdcIntent = Intent(Intent.ACTION_VIEW)
      val url = "https://www.cdc.gov/coronavirus/2019-ncov/prevent-getting-sick/prevention.html"
      cdcIntent.data = Uri.parse(url)
      startActivity(cdcIntent)
    }

    val broadcastSwitch = rootView.findViewById<SwitchMaterial>(R.id.broadcastSwitch)
    broadcastSwitch?.setOnCheckedChangeListener { _, isChecked ->
//      val msg: String = if (isChecked) "Broadcasting turned on" else "Broadcasting turned off"
      val msg: String
      if (isChecked) {
        msg = "Broadcasting turned on"
        Toasty.success(requireContext(), msg, Toast.LENGTH_SHORT).show()
        exposure.startScan()

      } else {
        msg = "Broadcasting turned off"
        Toasty.warning(requireContext(), msg, Toast.LENGTH_SHORT).show()
        exposure.stopScan()
      }

    }

    return rootView

  }


}