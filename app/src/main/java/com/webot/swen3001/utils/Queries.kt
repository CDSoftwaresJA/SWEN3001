package com.webot.swen3001.utils

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.webot.swen3001.models.SymptomsLog
import com.webot.swen3001.models.Exposures

@Dao
interface Queries {
    @Query("SELECT * FROM SymptomsLog")
    fun loadSymptomsLogs(): Array<SymptomsLog>


    @Insert
    fun insertSymptomsLogs(vararg todo: SymptomsLog)

}