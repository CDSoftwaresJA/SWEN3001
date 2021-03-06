package com.webot.swen3001.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class SymptomsLog(
    @PrimaryKey(autoGenerate = true) var id: Int,
    var date: String,
    var symptoms: String
)