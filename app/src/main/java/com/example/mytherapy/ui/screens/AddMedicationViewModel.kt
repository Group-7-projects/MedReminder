package com.example.mytherapy.ui.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mytherapy.data.entities.Medication
import com.example.mytherapy.data.entities.Reminder
import com.example.mytherapy.data.repository.MedicationRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddMedicationViewModel @Inject constructor(
    private val repository: MedicationRepository
) : ViewModel() {

    fun saveMedication(
        name: String,
        dosage: String,
        frequency: String,
        shape: String,
        hour: Int,
        minute: Int
    ) {
        viewModelScope.launch {
            val medication = Medication(
                name = name,
                dosage = dosage,
                frequency = frequency,
                shape = shape,
                color = "Blue"
            )
            val medId = repository.insertMedication(medication)
            
            val reminder = Reminder(
                medicationId = medId,
                timeHour = hour,
                timeMinute = minute
            )
            repository.insertReminder(reminder)
        }
    }
}
