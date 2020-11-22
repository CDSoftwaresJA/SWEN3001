package com.webot.swen3001.models

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

import com.webot.swen3001.R
import kotlinx.android.synthetic.main.item_view.view.*


class MyAdapter(private val data: Array<RequestDataItem>): RecyclerView.Adapter<MyHolder>() {


    override fun getItemCount(): Int {

        return 1
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val layoutInflater = LayoutInflater.from(parent?.context)
        val dataView = layoutInflater.inflate(R.layout.item_view, parent, false)
        return MyHolder(dataView)
        //number of item
    }


    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        data.reverse()
        val list = data.get(position)
        holder.itemView.confirm_data.text = list.confirmed.toString()
        holder.itemView.active_data.text = list.active.toString()
        holder.itemView.recovered_data.text=list.recovered.toString()
        holder.itemView.death_data.text=list.deaths.toString()
        holder.itemView.date_data.text=list.date.toString()


    }
}