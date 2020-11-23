package com.webot.swen3001.utils

import androidx.room.Database
import androidx.room.RoomDatabase
import com.webot.swen3001.models.Exposures
import com.webot.swen3001.models.SymptomsLog

@Database(entities = [SymptomsLog::class, Exposures::class], version = 1)

abstract class AppDatabase : RoomDatabase() {
    abstract fun queriesSymptoms(): Queries
    abstract fun queriesExposure():ExposureQueries
}