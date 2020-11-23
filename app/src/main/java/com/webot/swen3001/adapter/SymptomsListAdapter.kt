package com.webot.swen3001.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.webot.swen3001.R
import com.webot.swen3001.models.SymptomsLog
import kotlinx.android.synthetic.main.symptoms_list_item.view.*

class SymptomsListAdapter(private val array : ArrayList<SymptomsLog>) : RecyclerView.Adapter<SymptomsListAdapter.SymptomsListViewHolder>() {

    private var dummyDataList = ArrayList<SymptomsLog>()

    init {
        dummyDataList = array
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