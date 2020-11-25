package com.webot.swen3001.ui.status

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CompoundButton
import android.widget.Switch
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.webot.swen3001.R
import com.webot.swen3001.adapter.ExposuresAdapter
import com.webot.swen3001.databinding.FragmentNotificationsBinding
import com.webot.swen3001.models.Exposures
import com.webot.swen3001.utils.AppDatabase
import com.webot.swen3001.utils.Utils
import kotlin.concurrent.thread


class StatusFragment : Fragment() {

  private lateinit var binding: FragmentNotificationsBinding





  override fun onCreateView(
      inflater: LayoutInflater, container: ViewGroup?,
      savedInstanceState: Bundle?
  ): View? {


      val rootView: View = inflater.inflate(R.layout.fragment_notifications, container, false)
      


      thread {
          var dataList = ArrayList<Exposures>()

          val db = Room.databaseBuilder(
              requireContext(),
              AppDatabase::class.java, "tracer"
          ).build()

//          db.queriesExposure().insertExposureLogs(Exposures(0,"Test Date","20m"))


          val arr =       db.queriesExposure().loadExposureLogs()
          for (log in arr){
              var data = Exposures(0, log.distance, log.date)
              dataList.add(data)
              Log.d("Exposures: ", "${log.distance}")

          }

          requireActivity().runOnUiThread {
              val exposuresRecyclerView: RecyclerView = rootView.findViewById(R.id.exposuresRecyclerView)
              exposuresRecyclerView.adapter = ExposuresAdapter(
                  dataList
              )
              exposuresRecyclerView.layoutManager = LinearLayoutManager(
                  context
              )
              exposuresRecyclerView.setHasFixedSize(true)

          }



      }


      val exposure: Switch = rootView.findViewById(R.id.exposure)
//      val status: Switch = rootView.findViewById(R.id.status)

      exposure.isChecked= Utils.getNotification()
//      status.isChecked= Utils.getStatus()

      exposure.setOnCheckedChangeListener({ buttonView, isChecked ->
          Utils.updateNotification(isChecked)
      })
//
//      status.setOnCheckedChangeListener({ buttonView, isChecked ->
//
//          Utils.updateStatus(isChecked)
//
//      })




      return rootView

    }
}