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
import androidx.compose.foundation.layout.height
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
import com.jessimori.appclinicamedicasaludplus.ui.theme.components.HealthCardWithAction

class MainActivity : ComponentActivity() {

    private fun navigateToSaturacion() {
        startActivity(Intent(this, SaturacionOxigeno::class.java))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppClinicaMedicaSaludplusTheme {
                var visible by remember { mutableStateOf(false) }

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

                    AnimatedVisibility(
                        visible = visible,
                        enter = slideInVertically(
                            initialOffsetY = { it },
                            animationSpec = tween(800, delayMillis = 300)
                        ) + fadeIn(animationSpec = tween(800, delayMillis = 300))
                    ) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            HealthCardWithAction(
                                title = "Saturación de Oxígeno",
                                value = "98%",
                                buttonText = stringResource(R.string.saturacion_oxigeno),
                                onClick = ::navigateToSaturacion
                            )
                            HealthCardWithAction(
                                title = "Presión Arterial",
                                value = "120/80",
                                buttonText = stringResource(R.string.presion_arterial),
                                onClick = ::navigateToSaturacion
                            )
                            HealthCardWithAction(
                                title = "Temperatura",
                                value = "36.5°C",
                                buttonText = stringResource(R.string.temperatura),
                                onClick = ::navigateToSaturacion
                            )
                        }
                    }
                }
            }
        }
    }
}

