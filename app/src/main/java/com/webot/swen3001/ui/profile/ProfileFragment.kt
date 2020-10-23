package com.webot.swen3001.ui.profile

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputBinding
import androidx.lifecycle.ViewModelProvider
import androidx.fragment.app.Fragment
import com.webot.swen3001.ExposureNotifications
import com.webot.swen3001.R
import com.webot.swen3001.UpdateStatus
import com.webot.swen3001.databinding.FragmentNotificationsBinding
import kotlinx.android.synthetic.main.fragment_notifications.*

class ProfileFragment : Fragment() {

  private lateinit var viewModel: ProfileViewModel

  private lateinit var binding: FragmentNotificationsBinding




  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                            savedInstanceState: Bundle?): View? {


    // binding = FragmentNotificationsBinding.inflate(layoutInflater)
    val rootView: View = inflater.inflate(R.layout.fragment_notifications, container, false)


    Log.i("ProfileFragment", "Called ViewModelProvider.get")
    viewModel = ViewModelProvider(this).get(ProfileViewModel::class.java)

    //Adding event listener to the Update Status Card on Profile Screen
    val updateStatusCard: View = rootView.findViewById(R.id.mystatus_card)
    updateStatusCard.setOnClickListener {
      val updateMyStatusIntent = Intent(requireContext(), UpdateStatus::class.java)
      startActivity(updateMyStatusIntent)
    }

    //Adding event listener to the Exposure Notifications Card on Profile Screen
    val expNotificationsCard: View = rootView.findViewById(R.id.expNotifications_card)
    expNotificationsCard.setOnClickListener {
      val expNotificationsIntent = Intent(requireContext(), ExposureNotifications::class.java)
      startActivity(expNotificationsIntent)
    }

  /*  val status_State: View = rootView.findViewById(R.id.statusState)
    val expNotificationsState: View = rootView.findViewById(R.id.expNotificationsState)
    fun setTextViewText(value: String){
      statusState.text = value
    } */

    return rootView

  }
}