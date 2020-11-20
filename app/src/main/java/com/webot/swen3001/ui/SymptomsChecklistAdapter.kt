package com.webot.swen3001.ui

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.CheckBox
import com.webot.swen3001.R
import kotlinx.android.synthetic.main.symptoms_checklist_item.view.*

class SymptomsChecklistAdapter(context: Context) : BaseAdapter() {

    private var symptomsList = listOf<String>()
    private var mContext: Context
//    private lateinit var itemView: View

    init {
        mContext = context

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

    override fun getCount() = symptomsList.size

    override fun getItem(position: Int): Any {
        return symptomsList[position]
    }

    override fun getItemId(position: Int): Long {
        return symptomsList[position].hashCode().toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val symptom = getItem(position) as String

        val itemView = LayoutInflater.from(mContext).inflate(R.layout.symptoms_checklist_item, parent, false)
//        itemView.setOnClickListener(this)

        val checkBox: CheckBox = itemView.CheckBox
        checkBox.text = symptom
        return itemView
    }

//    override fun onClick(v: View?) {
//        if (itemView.CheckBox.isChecked) {
//            itemView.cardView.setCardBackgroundColor(Color.parseColor("#F2F1F1"))
//            itemView.CheckBox.setTextColor(Color.BLACK)
//            itemView.CheckBox.isChecked = false
//        } else {
//            itemView.cardView.setCardBackgroundColor(Color.parseColor("#0394F3"))
//            itemView.CheckBox.setTextColor(Color.WHITE)
//            itemView.CheckBox.isChecked = true
//        }
//    }
    //    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SymptomsChecklistViewHolder {
//        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.symptoms_checklist_item,
//        parent, false)
//        return SymptomsChecklistViewHolder(itemView)
//    }
//
//    override fun onBindViewHolder(holder: SymptomsChecklistViewHolder, position: Int) {
//        val currentItem = symptomsList[position]
//        holder.checkBox.text = currentItem
//    }
//
//    override fun getItemCount() = symptomsList.size
//
//    class SymptomsChecklistViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
//        val checkBox: CheckBox = itemView.CheckBox
//
//
//        init {
//            itemView.setOnClickListener(this)
//        }
//

//        }
//    }
}