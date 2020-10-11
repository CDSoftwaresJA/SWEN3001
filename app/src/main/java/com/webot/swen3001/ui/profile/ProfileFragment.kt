package com.webot.swen3001.ui.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.webot.swen3001.R

class ProfileFragment : Fragment() {


  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {

    return inflater.inflate(R.layout.fragment_notifications, container, false)
  }
}