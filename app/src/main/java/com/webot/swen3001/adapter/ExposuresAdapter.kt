package com.webot.swen3001.adapter

import com.webot.swen3001.models.SymptomsListItem

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.webot.swen3001.R
import kotlinx.android.synthetic.main.symptoms_list_item.view.*

class ExposuresAdapter(private val array : ArrayList<SymptomsListItem>) : RecyclerView.Adapter<ExposuresAdapter.ListViewHolder>() {

    private var dummyDataList = ArrayList<SymptomsListItem>()

    init {
        dummyDataList = array
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.symptoms_list_item,
            parent, false)
        return ListViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val currentItem = dummyDataList[position]
        holder.symptoms.text = currentItem.symptoms
        holder.date.text = currentItem.date
    }

    override fun getItemCount() = dummyDataList.size

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val symptoms: TextView = itemView.symptoms
        val date: TextView = itemView.date
    }

}