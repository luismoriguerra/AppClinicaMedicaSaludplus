package com.jessimori.appclinicamedicasaludplus.ui.theme.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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

/**
 * Componente reutilizable: HealthCard con botón de acción
 */
@Composable
fun HealthCardWithAction(
    title: String,
    value: String,
    buttonText: String,
    onClick: () -> Unit
) {
    HealthCard(title = title, value = value)
    Button(onClick = onClick) {
        Text(buttonText)
    }
}

/**
 * Componente reutilizable: Botón de grid (para la pantalla de saturación)
 */
@Composable
fun RowScope.GridButton(
    text: String,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .weight(1f)
            .height(56.dp),
        shape = RoundedCornerShape(12.dp)
    ) {
        Text(
            text = text,
            fontSize = 12.sp,
            textAlign = TextAlign.Center
        )
    }
}

/**
 * Componente reutilizable: Botón "Volver a Inicio"
 */
@Composable
fun BackToHomeButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    OutlinedButton(
        onClick = onClick,
        modifier = modifier
            .fillMaxWidth()
            .height(48.dp),
        shape = RoundedCornerShape(12.dp)
    ) {
        Text(
            text = text,
            fontSize = 14.sp
        )
    }
}