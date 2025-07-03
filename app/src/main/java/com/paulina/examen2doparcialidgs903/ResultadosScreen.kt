package com.paulina.examen2doparcialidgs903


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.material3.*
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign

@Composable
fun PantallaResultados(nombre: String, edad: Int, signo: String, calificacion: Int) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        Text("Hola $nombre", fontSize = 22.sp, fontWeight = FontWeight.Bold)
        Text("Tienes $edad años y tu signo zodiacal", fontSize = 18.sp)
        Text("Es $signo", fontSize = 18.sp, fontWeight = FontWeight.Bold)

        Image(
            painter = painterResource(id = getSignoDrawable(signo.lowercase())),
            contentDescription = null,
            modifier = Modifier.size(150.dp)
        )

        Text("Calificación: $calificacion", fontSize = 20.sp, fontWeight = FontWeight.Bold, textAlign = TextAlign.Center)
    }
}
fun getSignoDrawable(signo: String): Int {
    return when (signo.lowercase()) {
        "rata" -> R.drawable.rata
        "buey" -> R.drawable.buey
        "tigre" -> R.drawable.tigre
        "conejo" -> R.drawable.conejo
        "dragón", "dragon" -> R.drawable.dragon
        "serpiente" -> R.drawable.serpiente
        "caballo" -> R.drawable.caballo
        "cabra" -> R.drawable.cabra
        "mono" -> R.drawable.mono
        "gallo" -> R.drawable.gallo
        "perro" -> R.drawable.perro
        "cerdo" -> R.drawable.cerdo
        else -> R.drawable.signo_desconocido
    }
    }