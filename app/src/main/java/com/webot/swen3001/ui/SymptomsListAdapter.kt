package com.webot.swen3001.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.webot.swen3001.R
import kotlinx.android.synthetic.main.symptoms_list_item.view.*

class SymptomsListAdapter : RecyclerView.Adapter<SymptomsListAdapter.SymptomsListViewHolder>() {

    private val dummyDataList = ArrayList<SymptomsListItem>()

    init {
        var dummyData1 = SymptomsListItem("Cough, Fever", "October 09, 2020")
        var dummyData2 = SymptomsListItem("Sore Through, Nausea", "November 01, 2020")

        dummyDataList += dummyData1
        dummyDataList += dummyData2
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SymptomsListViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.symptoms_list_item,
            parent, false)
        return SymptomsListViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: SymptomsListViewHolder, position: Int) {
        val currentItem = dummyDataList[position]
        holder.symptoms.text = currentItem.symptoms
        holder.date.text = currentItem.date
    }

    override fun getItemCount() = dummyDataList.size

    class SymptomsListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val symptoms: TextView = itemView.symptoms
        val date: TextView = itemView.date
    }

}