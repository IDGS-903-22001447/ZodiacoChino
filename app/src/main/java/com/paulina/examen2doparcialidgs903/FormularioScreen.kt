package com.paulina.examen2doparcialidgs903

import android.content.Context
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun PantallaFormulario(navController: NavController, context: Context) {
    var nombre by remember { mutableStateOf("") }
    var dia by remember { mutableStateOf("") }
    var mes by remember { mutableStateOf("") }
    var anio by remember { mutableStateOf("") }
    var sexo by remember { mutableStateOf("Hombre") }

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text("Formulario", style = MaterialTheme.typography.headlineMedium)

        OutlinedTextField(value = nombre, onValueChange = { nombre = it }, label = { Text("Nombre Completo") }, modifier = Modifier.fillMaxWidth())
        OutlinedTextField(value = dia, onValueChange = { dia = it }, label = { Text("Día") }, modifier = Modifier.fillMaxWidth())
        OutlinedTextField(value = mes, onValueChange = { mes = it }, label = { Text("Mes") }, modifier = Modifier.fillMaxWidth())
        OutlinedTextField(value = anio, onValueChange = { anio = it }, label = { Text("Año") }, modifier = Modifier.fillMaxWidth())

        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(selected = sexo == "Hombre", onClick = { sexo = "Hombre" })
            Text("Hombre")
            Spacer(modifier = Modifier.width(16.dp))
            RadioButton(selected = sexo == "Mujer", onClick = { sexo = "Mujer" })
            Text("Mujer")
        }

        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            Button(onClick = {
                nombre = ""
                dia = ""
                mes = ""
                anio = ""
                sexo = "Hombre"
            }) {
                Text("Limpiar")
            }

            Button(onClick = {
                if (nombre.isNotBlank() && dia.isNotBlank() && mes.isNotBlank() && anio.isNotBlank()) {
                    navController.navigate("examen/$nombre/$dia/$mes/$anio")
                } else {
                    print("Error: Todos los campos deben estar llenos.")
                }
                navController.navigate("examen/$nombre/$dia/$mes/$anio")


            }) {
                Text("Siguiente")
            }
        }
    }
}