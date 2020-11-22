package com.webot.swen3001.ui.profile

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.webot.swen3001.R
import kotlinx.android.synthetic.main.possible_exposure.view.*

class ExposuresViewAdapter : RecyclerView.Adapter<ExposuresViewAdapter.ViewHolder>() {

    private val exposureNames = arrayOf("Possible Exposure", "Possible Exposure")
    private val exposureDates = arrayOf("June 30, 2020", "August 30, 2020")


    inner class ViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView){
        var exposure: TextView
        var date: TextView


        init{
            exposure = itemView.findViewById(R.id.exp_itemName)
            date = itemView.findViewById(R.id.exp_itemDate)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.possible_exposure,parent,false)
        return ViewHolder(v)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.exposure.text = exposureNames [position]
        holder.date.text = exposureDates [position]
    }

    override fun getItemCount(): Int {
        return exposureNames.size
    }

}