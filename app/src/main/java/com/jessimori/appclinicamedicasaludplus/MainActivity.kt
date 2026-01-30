package com.jessimori.appclinicamedicasaludplus

//https://www.behance.net/gallery/241327955/Healthcare-Mobile-App-UIUX-Design/modules/1390878193

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.jessimori.appclinicamedicasaludplus.ui.theme.AppClinicaMedicaSaludplusTheme
import com.jessimori.appclinicamedicasaludplus.ui.theme.components.HealthCard
import com.jessimori.appclinicamedicasaludplus.ui.theme.saturacion_oxigeno

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppClinicaMedicaSaludplusTheme {
                Column(modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(text = stringResource(R.string.frase),
                        style = MaterialTheme.typography.titleLarge)
                    //style = TextStyle(fontSize = 24.sp,fontWeight = FontWeight.Bold)
                }
                Column (modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center){
                    Image(painterResource(R.drawable.logopulmon),
                        contentDescription = stringResource(R.string.texto_logo),
                        modifier = Modifier.height(240.dp))
                    Text(text = stringResource(R.string.saturacion_oxigeno),
                        style = MaterialTheme.typography.displayLarge)
                    //style = TextStyle(fontSize = 72.sp, fontWeight = FontWeight.Bold))

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

