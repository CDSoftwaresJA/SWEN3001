package com.webot.swen3001.ui

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.CheckBox
import androidx.cardview.widget.CardView
import com.webot.swen3001.R
import kotlinx.android.synthetic.main.symptoms_checklist_item.view.*

class SymptomsChecklistAdapter(context: Context) : BaseAdapter() {

    private var symptomsList = listOf<String>()
    private var checkBoxListState = mutableListOf<Boolean>()
    private var mContext = context

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

        for(symptom in symptomsList) {
            checkBoxListState.plusAssign(false)
        }
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
        val checkBox = itemView.CheckBox
        val cardView = itemView.cardView

        checkBox.text = symptom
        setCheckBoxState(cardView, checkBox, position)

        fun onClick() {
            if(!checkBoxListState[position]) {
                cardView.setCardBackgroundColor(Color.parseColor("#0394F3"))
                checkBox.setTextColor(Color.WHITE)
                checkBoxListState[position] = true
            } else {
                cardView.setCardBackgroundColor(Color.parseColor("#F2F1F1"))
                checkBox.setTextColor(Color.BLACK)
                checkBoxListState[position] = false
            }
        }

        checkBox.setOnClickListener(View.OnClickListener() {
            onClick()
//            Toast.makeText(mContext, "You Clicked:"+" "+symptom, Toast.LENGTH_SHORT).show()
        })


        cardView.setOnClickListener(View.OnClickListener {
            onClick()
            checkBox.isChecked = checkBoxListState[position]
//            Toast.makeText(mContext, "You Clicked:"+" "+symptom, Toast.LENGTH_SHORT).show()
        })

        return itemView
    }

    private fun setCheckBoxState(cardView: CardView, checkBox: CheckBox, position: Int) {
        if(checkBoxListState[position]) {
            cardView.setCardBackgroundColor(Color.parseColor("#0394F3"))
            checkBox.setTextColor(Color.WHITE)
            checkBox.isChecked = true
        } else {
            cardView.setCardBackgroundColor(Color.parseColor("#F2F1F1"))
            checkBox.setTextColor(Color.BLACK)
            checkBox.isChecked = false
        }
    }
}