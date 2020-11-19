package com.webot.swen3001

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.webot.swen3001.models.SymptomsLog

@Dao
interface Queries {
    @Query("SELECT * FROM SymptomsLog")
    fun loadLogs(): Array<SymptomsLog>


    @Insert
    fun insertAll(vararg todo: SymptomsLog)
}