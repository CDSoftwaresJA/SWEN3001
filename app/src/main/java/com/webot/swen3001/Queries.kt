package com.webot.swen3001

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.webot.swen3001.models.ExposureLog

@Dao
interface Queries {
    @Query("SELECT * FROM ExposureLog")
    fun loadLogs(): Array<ExposureLog>


    @Insert
    fun insertAll(vararg todo: ExposureLog)
}