package com.webot.swen3001.ui.profile

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.webot.swen3001.ExposureNotifications
import com.webot.swen3001.R
import com.webot.swen3001.UpdateStatus

class ProfileFragment : Fragment() {


  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {

    val rootView: View = inflater.inflate(R.layout.fragment_notifications, container, false)

    //Adding event listener to the Update My Status card
    val myStatusCard: View = rootView.findViewById(R.id.mystatus_card)
    myStatusCard.setOnClickListener {
      val intent = Intent(requireContext(),UpdateStatus::class.java)
      startActivity(intent)
    }


    //Adding event listener to the Exposure Notifications card
    val expNotificationsCard: View = rootView.findViewById(R.id.expNotifications_card)
    expNotificationsCard.setOnClickListener {
      val intent = Intent(requireContext(),ExposureNotifications::class.java)
      startActivity(intent)
    }
    return rootView
  }
}