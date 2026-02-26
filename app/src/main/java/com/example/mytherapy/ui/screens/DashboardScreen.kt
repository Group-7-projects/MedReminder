package com.example.mytherapy.ui.screens

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mytherapy.ui.theme.*

data class Medication(val id: Int, val name: String, val dosage: String, val time: String, val status: String)

@Composable
fun DashboardScreen(modifier: Modifier = Modifier, onOpenSettings: () -> Unit) {
    val medications = listOf(
        Medication(1, "Lisinopril", "10mg", "08:00 AM", "taken"),
        Medication(2, "Vitamin D3", "2000 IU", "08:00 AM", "taken"),
        Medication(3, "Metformin", "500mg", "01:00 PM", "pending"),
        Medication(4, "Atorvastatin", "20mg", "08:00 PM", "pending")
    )

    val takenCount = medications.count { it.status == "taken" }
    val totalCount = medications.size
    val progress = if (totalCount > 0) takenCount.toFloat() / totalCount.toFloat() else 0f
    
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(bottom = 24.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text("Hello, Jane", style = MaterialTheme.typography.titleLarge)
                Text("Stay healthy today", style = MaterialTheme.typography.bodyMedium)
            }
            IconButton(onClick = onOpenSettings, modifier = Modifier.background(Color.White, CircleShape)) {
                Icon(Icons.Filled.Person, contentDescription = "Settings", tint = Primary)
            }
        }

        Card(
            colors = CardDefaults.cardColors(containerColor = Color.White),
            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
            modifier = Modifier.fillMaxWidth().padding(bottom = 24.dp)
        ) {
            Row(
                modifier = Modifier.padding(16.dp).fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text("Today's Progress", fontWeight = FontWeight.Bold, fontSize = 20.sp)
                    Spacer(modifier = Modifier.height(8.dp))
                    Text("Medications", style = MaterialTheme.typography.bodyMedium)
                    Text("$takenCount / $totalCount Taken", color = Primary, fontWeight = FontWeight.Bold)
                }

                Box(contentAlignment = Alignment.Center, modifier = Modifier.size(60.dp)) {
                    CircularProgressIndicator(
                        progress = 1f,
                        color = PrimarySoft,
                        strokeWidth = 8.dp,
                        modifier = Modifier.fillMaxSize()
                    )
                    CircularProgressIndicator(
                        progress = progress,
                        color = Primary,
                        strokeWidth = 8.dp,
                        strokeCap = StrokeCap.Round,
                        modifier = Modifier.fillMaxSize()
                    )
                    Text("${(progress * 100).toInt()}%", fontWeight = FontWeight.Bold, color = Primary)
                }
            }
        }

        Text("Schedule", style = MaterialTheme.typography.titleMedium, modifier = Modifier.padding(bottom = 8.dp))

        medications.forEach { med ->
            MedicationScheduleItem(med)
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

@Composable
fun MedicationScheduleItem(med: Medication) {
    val isTaken = med.status == "taken"
    
    Card(
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp),
        modifier = Modifier.fillMaxWidth()
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
                        .background(if (isTaken) PrimarySoft else SurfaceHover),
                    contentAlignment = Alignment.Center
                ) {
                    if (isTaken) {
                        Icon(Icons.Filled.Check, contentDescription = null, tint = Primary)
                    }
                }
                Spacer(modifier = Modifier.width(16.dp))
                Column {
                    Text(med.name, fontWeight = FontWeight.Bold)
                    Text("${med.dosage} • ${med.time}", style = MaterialTheme.typography.bodyMedium)
                }
            }

            Button(
                onClick = { },
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (isTaken) BackgroundColor else Primary,
                    contentColor = if (isTaken) TextMuted else Color.White
                ),
                contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
            ) {
                Text(if (isTaken) "Undo" else "Take")
            }
        }
    }
}
