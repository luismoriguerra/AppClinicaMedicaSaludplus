package com.jessimori.appclinicamedicasaludplus

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.jessimori.appclinicamedicasaludplus.ui.theme.AppClinicaMedicaSaludplusTheme
import com.jessimori.appclinicamedicasaludplus.ui.theme.components.BackToHomeButton
import com.jessimori.appclinicamedicasaludplus.ui.theme.components.GridButton

class SaturacionOxigeno : ComponentActivity() {

    private fun navigateToResultado() {
        startActivity(Intent(this, ResultadoTest::class.java))
    }

    private fun navigateToHome() {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppClinicaMedicaSaludplusTheme {
                Column {
                    Box(contentAlignment = Alignment.BottomEnd) {
                        Image(
                            painterResource(R.drawable.cuadroblood),
                            contentDescription = null,
                            modifier = Modifier.height(400.dp),
                            contentScale = ContentScale.Crop
                        )
                    }
                    Column(
                        modifier = Modifier
                            .fillMaxHeight()
                            .padding(16.dp),
                        verticalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = stringResource(R.string.saturacion_oxigeno),
                            style = MaterialTheme.typography.headlineSmall
                        )

                        // Grid 2x2 de botones usando componente reutilizable
                        Column(
                            modifier = Modifier.fillMaxWidth(),
                            verticalArrangement = Arrangement.spacedBy(12.dp)
                        ) {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.spacedBy(12.dp)
                            ) {
                                GridButton(
                                    text = stringResource(R.string.saturacion_oxigeno),
                                    onClick = ::navigateToResultado
                                )
                                GridButton(
                                    text = stringResource(R.string.conteo_sanguineo),
                                    onClick = ::navigateToResultado
                                )
                            }
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.spacedBy(12.dp)
                            ) {
                                GridButton(
                                    text = stringResource(R.string.ritmo_cardiaco),
                                    onClick = ::navigateToResultado
                                )
                                GridButton(
                                    text = stringResource(R.string.nivel_glucosa),
                                    onClick = ::navigateToResultado
                                )
                            }
                        }

                        Spacer(modifier = Modifier.height(16.dp))

                        BackToHomeButton(
                            text = stringResource(R.string.volver_inicio),
                            onClick = ::navigateToHome
                        )
                    }
                }
            }
        }
    }
}

// Alias para compatibilidad con código existente
@Deprecated("Use SaturacionOxigeno instead", ReplaceWith("SaturacionOxigeno"))
typealias saturacion_oxigeno = SaturacionOxigeno


