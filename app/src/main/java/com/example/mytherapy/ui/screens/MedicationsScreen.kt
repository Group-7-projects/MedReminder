package com.example.mytherapy.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.mytherapy.ui.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MedicationsScreen(modifier: Modifier = Modifier) {
    val meds = listOf(
        Medication(1, "Lisinopril", "10mg", "Daily", ""),
        Medication(2, "Vitamin D3", "2000 IU", "Daily", ""),
        Medication(3, "Metformin", "500mg", "Twice Daily", "")
    )

    Column(modifier = modifier.fillMaxSize().padding(16.dp)) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("My Medications", style = MaterialTheme.typography.titleLarge)
            Button(onClick = {}, colors = ButtonDefaults.buttonColors(containerColor = Primary)) {
                Icon(Icons.Filled.Add, contentDescription = "Add")
                Spacer(Modifier.width(4.dp))
                Text("Add")
            }
        }

        OutlinedTextField(
            value = "",
            onValueChange = {},
            modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp),
            placeholder = { Text("Search medications...") },
            leadingIcon = { Icon(Icons.Filled.Search, contentDescription = null) },
            shape = RoundedCornerShape(24.dp),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Primary,
                unfocusedBorderColor = Color.Transparent,
                containerColor = SurfaceColor
            )
        )

        meds.forEach { med ->
            Card(
                colors = CardDefaults.cardColors(containerColor = Color.White),
                elevation = CardDefaults.cardElevation(defaultElevation = 1.dp),
                modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp)
            ) {
                Row(
                    modifier = Modifier.padding(16.dp).fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Box(
                            modifier = Modifier
                                .size(40.dp)
                                .clip(RoundedCornerShape(8.dp))
                                .background(PrimarySoft),
                            contentAlignment = Alignment.Center
                        ) {
                           // Pill Icon placeholder
                           Text("P", color = Primary, fontWeight = FontWeight.Bold)
                        }
                        Spacer(modifier = Modifier.width(16.dp))
                        Column {
                            Text(med.name, fontWeight = FontWeight.Bold)
                            Text("${med.dosage} • ${med.time}", style = MaterialTheme.typography.bodyMedium)
                        }
                    }

                    Row {
                        IconButton(onClick = {}) { Icon(Icons.Filled.Edit, contentDescription = "Edit", tint = Secondary) }
                        IconButton(onClick = {}) { Icon(Icons.Filled.Delete, contentDescription = "Delete", tint = Danger) }
                    }
                }
            }
        }
    }
}
