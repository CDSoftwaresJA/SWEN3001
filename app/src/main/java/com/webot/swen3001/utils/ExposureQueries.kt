package com.webot.swen3001.utils

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.webot.swen3001.models.Exposures

@Dao
interface ExposureQueries {

    @Query("SELECT * FROM Exposures")
    fun loadExposureLogs(): Array<Exposures>


    @Insert
    fun insertExposureLogs(vararg todo: Exposures)
}