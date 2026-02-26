package com.example.mytherapy.data.repository

import com.example.mytherapy.data.entities.Medication
import com.example.mytherapy.data.entities.Reminder
import com.example.mytherapy.data.local.MedicationDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MedicationRepository @Inject constructor(
    private val medicationDao: MedicationDao
) {
    fun getAllMedications(): Flow<List<Medication>> = medicationDao.getAllMedications()

    suspend fun insertMedication(medication: Medication): Long {
        return medicationDao.insertMedication(medication)
    }

    suspend fun deleteMedication(medication: Medication) {
        medicationDao.deleteMedication(medication)
    }

    fun getRemindersForMedication(medicationId: Long): Flow<List<Reminder>> {
        return medicationDao.getRemindersForMedication(medicationId)
    }

    suspend fun insertReminder(reminder: Reminder) {
        medicationDao.insertReminder(reminder)
    }

    suspend fun updateReminder(reminder: Reminder) {
        medicationDao.updateReminder(reminder)
    }
}
