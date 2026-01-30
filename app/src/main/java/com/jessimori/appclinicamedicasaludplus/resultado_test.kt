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
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.jessimori.appclinicamedicasaludplus.ui.theme.AppClinicaMedicaSaludplusTheme

class resultado_test : ComponentActivity() {

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

                    // TÍTULO
                    Text(
                        text = stringResource(R.string.resultado_test),
                        style = MaterialTheme.typography.titleLarge
                    )

                    // LOGO
                    Image(
                        painter = painterResource(R.drawable.logopulmon),
                        contentDescription = stringResource(R.string.texto_logo),
                        modifier = Modifier.height(180.dp)
                    )

                    // IMAGEN RESULTADO
                    Image(
                        painter = painterResource(R.drawable.presionarterial),
                        contentDescription = stringResource(R.string.texto_logo),
                        modifier = Modifier.height(240.dp)
                    )

                    // TEXTO RESULTADO
                    Text(
                        text = stringResource(R.string.saturacion_oxigeno),
                        style = MaterialTheme.typography.displayLarge
                    )

                    // BOTÓN
                    Button(
                        onClick = {
                            startActivity(
                                Intent(
                                    this@resultado_test,
                                    saturacion_oxigeno::class.java
                                )
                            )
                        }
                    ) {
                        Text(stringResource(R.string.detalles))
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    // Botón Volver a Inicio
                    OutlinedButton(
                        onClick = {
                            startActivity(Intent(this@resultado_test, MainActivity::class.java))
                            finish()
                        },
                        modifier = Modifier
                            .padding(horizontal = 32.dp)
                            .fillMaxWidth()
                            .height(48.dp),
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        Text(stringResource(R.string.volver_inicio))
                    }
                }
            }
        }
    }
}
