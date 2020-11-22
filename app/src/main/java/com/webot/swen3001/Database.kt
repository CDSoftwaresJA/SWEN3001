package com.webot.swen3001

import androidx.room.Database
import androidx.room.RoomDatabase
import com.webot.swen3001.models.SymptomsLog

@Database(entities = arrayOf(SymptomsLog::class), version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun queries(): Queries
}