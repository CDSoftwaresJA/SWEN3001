package com.webot.swen3001.ui.profile

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputBinding
import android.widget.TextView
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


      val rootView: View = inflater.inflate(R.layout.fragment_notifications, container, false)

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



   /* binding = FragmentNotificationsBinding.inflate(layoutInflater)

    Log.i("ProfileFragment", "Called ViewModelProvider.get")
    viewModel = ViewModelProvider(this).get(ProfileViewModel::class.java)


          return binding.root*/


   /* override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

     binding.mystatusCard.setOnClickListener {
       val updateMyStatusIntent = Intent(requireContext(), UpdateStatus::class.java)
       startActivity(updateMyStatusIntent)
     }

      binding.expNotificationsCard.setOnClickListener {
        val expNotificationsIntent = Intent(requireContext(), ExposureNotifications::class.java)
        startActivity(expNotificationsIntent)
      }
*/

    return rootView

    }
}