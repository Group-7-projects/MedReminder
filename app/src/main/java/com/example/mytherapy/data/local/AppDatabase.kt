package com.example.mytherapy.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.mytherapy.data.entities.Medication
import com.example.mytherapy.data.entities.Reminder

@Database(entities = [Medication::class, Reminder::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun medicationDao(): MedicationDao
}
