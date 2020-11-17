package com.webot.swen3001.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import androidx.recyclerview.widget.RecyclerView
import com.webot.swen3001.R
import kotlinx.android.synthetic.main.symptoms_checklist_item.view.*

class SymptomsChecklistAdapter : RecyclerView.Adapter<SymptomsChecklistAdapter.SymptomsChecklistViewHolder>() {

    private var symptomsList = listOf<String>()
    init {
        symptomsList += "Sore Throat"
        symptomsList += "Fever"
        symptomsList += "Nasal Congestion"
        symptomsList += "Cough"
        symptomsList += "Difficulty Breathing"
        symptomsList += "Fatigue"
        symptomsList += "Body/Muscle Aches"
        symptomsList += "Nausea"
        symptomsList += "Headache"
        symptomsList += "Loss of taste/smell"
        symptomsList += "Chest Pain"
        symptomsList += "Diarrhea"
        symptomsList += "Abdominal Pain"
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SymptomsChecklistViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.symptoms_checklist_item,
        parent, false)
        return SymptomsChecklistViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: SymptomsChecklistViewHolder, position: Int) {
        val currentItem = symptomsList[position]
        holder.checkBox.text = currentItem
    }

    override fun getItemCount() = symptomsList.size

    class SymptomsChecklistViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val checkBox: CheckBox = itemView.CheckBox
    }

}