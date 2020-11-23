package com.webot.swen3001.ui.status

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.webot.swen3001.R
import com.webot.swen3001.databinding.FragmentNotificationsBinding

class StatusFragment : Fragment() {

  private lateinit var viewModel: StatusViewModel

  private lateinit var binding: FragmentNotificationsBinding





  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                            savedInstanceState: Bundle?): View? {


      val rootView: View = inflater.inflate(R.layout.fragment_notifications, container, false)


      val exposuresRecyclerView: RecyclerView = rootView.findViewById(R.id.exposuresRecyclerView)




      //ADDING EVENT LISTENER TO THE UPDATE STATUS CARD ON PROFILE SCREEN
      val updateStatusCard: View = rootView.findViewById(R.id.mystatus_card)
      updateStatusCard.setOnClickListener {
          val updateMyStatusIntent = Intent(requireContext(), UpdateStatus::class.java)
          startActivity(updateMyStatusIntent)
      }

      //ADDING EVENT LISTENER TO THE EXPOSURE NOTIFICATIONS CARD ON PROFILE SCREEN
      val expNotificationsCard: View = rootView.findViewById(R.id.expNotifications_card)
      expNotificationsCard.setOnClickListener {
          val expNotificationsIntent = Intent(requireContext(), ExposureNotifications::class.java)
          startActivity(expNotificationsIntent)
      }



    return rootView

    }
}