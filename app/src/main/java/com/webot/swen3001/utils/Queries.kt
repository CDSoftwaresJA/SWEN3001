package com.webot.swen3001.utils

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.webot.swen3001.models.SymptomsLog

@Dao
interface Queries {
    @Query("SELECT * FROM SymptomsLog")
    fun loadSymptomsLogs(): Array<SymptomsLog>


    @Insert
    fun insertSymptomsLogs(vararg todo: SymptomsLog)

    @Query("SELECT * FROM SymptomsLog")
    fun loadExposureLogs(): Array<SymptomsLog>


    @Insert
    fun insertExposureLogs(vararg todo: SymptomsLog)
}