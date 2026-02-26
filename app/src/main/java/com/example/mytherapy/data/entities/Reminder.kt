package com.example.mytherapy.data.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "reminders",
    foreignKeys = [
        ForeignKey(
            entity = Medication::class,
            parentColumns = ["id"],
            childColumns = ["medicationId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class Reminder(
    @field:PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val medicationId: Long,
    val timeHour: Int,
    val timeMinute: Int,
    val isTaken: Boolean = false,
    val takenTimeMillis: Long? = null
)
