package com.jessimori.appclinicamedicasaludplus.ui.theme.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.jessimori.appclinicamedicasaludplus.ui.theme.BluePrimary
import com.jessimori.appclinicamedicasaludplus.ui.theme.TextPrimary
import com.jessimori.appclinicamedicasaludplus.ui.theme.WhiteSurface

@Composable
fun HealthCard(
    title: String,
    value: String
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        colors = CardDefaults.cardColors(
            containerColor = WhiteSurface
        ),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.titleMedium,
                color = TextPrimary
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = value,
                style = MaterialTheme.typography.displaySmall,
                color = BluePrimary
            )
        }
    }
}