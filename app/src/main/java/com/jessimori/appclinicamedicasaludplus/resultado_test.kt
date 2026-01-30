package com.jessimori.appclinicamedicasaludplus

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.jessimori.appclinicamedicasaludplus.ui.theme.AppClinicaMedicaSaludplusTheme
import com.jessimori.appclinicamedicasaludplus.ui.theme.components.BackToHomeButton

class ResultadoTest : ComponentActivity() {

    private fun navigateToSaturacion() {
        startActivity(Intent(this, SaturacionOxigeno::class.java))
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
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = stringResource(R.string.resultado_test),
                        style = MaterialTheme.typography.titleLarge
                    )

                    Image(
                        painter = painterResource(R.drawable.logopulmon),
                        contentDescription = stringResource(R.string.texto_logo),
                        modifier = Modifier.height(180.dp)
                    )

                    Image(
                        painter = painterResource(R.drawable.presionarterial),
                        contentDescription = stringResource(R.string.texto_logo),
                        modifier = Modifier.height(240.dp)
                    )

                    Text(
                        text = stringResource(R.string.saturacion_oxigeno),
                        style = MaterialTheme.typography.displayLarge
                    )

                    Button(onClick = ::navigateToSaturacion) {
                        Text(stringResource(R.string.detalles))
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    BackToHomeButton(
                        text = stringResource(R.string.volver_inicio),
                        onClick = ::navigateToHome,
                        modifier = Modifier.padding(horizontal = 32.dp)
                    )
                }
            }
        }
    }
}

// Alias para compatibilidad con código existente
@Deprecated("Use ResultadoTest instead", ReplaceWith("ResultadoTest"))
typealias resultado_test = ResultadoTest
