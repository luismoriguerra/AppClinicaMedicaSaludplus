package com.jessimori.appclinicamedicasaludplus

//https://www.behance.net/gallery/241327955/Healthcare-Mobile-App-UIUX-Design/modules/1390878193

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.scaleIn
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.jessimori.appclinicamedicasaludplus.ui.theme.AppClinicaMedicaSaludplusTheme
import com.jessimori.appclinicamedicasaludplus.ui.theme.components.HealthCard

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        // Install SplashScreen before super.onCreate()
        installSplashScreen()
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppClinicaMedicaSaludplusTheme {
                // Animation state
                var visible by remember { mutableStateOf(false) }

                // Trigger animation when composable enters composition
                LaunchedEffect(Unit) {
                    visible = true
                }

                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = stringResource(R.string.frase),
                        style = MaterialTheme.typography.titleLarge
                    )

                    // ANIMATION 1: Fade In + Scale for Logo
                    AnimatedVisibility(
                        visible = visible,
                        enter = fadeIn(animationSpec = tween(1000)) +
                                scaleIn(initialScale = 0.8f, animationSpec = tween(1000))
                    ) {
                        Image(
                            painterResource(R.drawable.logopulmon),
                            contentDescription = stringResource(R.string.texto_logo),
                            modifier = Modifier.height(240.dp)
                        )
                    }

                    Text(
                        text = stringResource(R.string.saturacion_oxigeno),
                        style = MaterialTheme.typography.displayLarge
                    )

                    // ANIMATION 2: Slide In from bottom for HealthCards
                    AnimatedVisibility(
                        visible = visible,
                        enter = slideInVertically(
                            initialOffsetY = { it },
                            animationSpec = tween(800, delayMillis = 300)
                        ) + fadeIn(animationSpec = tween(800, delayMillis = 300))
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            HealthCard(
                                title = "Saturación de Oxígeno",
                                value = "98%"
                            )
                            Button(onClick = {
                                startActivity(Intent(this@MainActivity, saturacion_oxigeno::class.java))
                            }) {
                                Text(stringResource(R.string.saturacion_oxigeno))
                            }

                            HealthCard(
                                title = "Presión Arterial",
                                value = "120/80"
                            )
                            Button(onClick = {
                                startActivity(Intent(this@MainActivity, saturacion_oxigeno::class.java))
                            }) {
                                Text(stringResource(R.string.presion_arterial))
                            }

                            HealthCard(
                                title = "Temperatura",
                                value = "36.5°C"
                            )
                            Button(onClick = {
                                startActivity(Intent(this@MainActivity, saturacion_oxigeno::class.java))
                            }) {
                                Text(stringResource(R.string.temperatura))
                            }
                        }
                    }
                }
            }
        }
    }
}

