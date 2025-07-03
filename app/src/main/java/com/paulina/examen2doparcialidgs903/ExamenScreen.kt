package com.paulina.examen2doparcialidgs903
import android.content.Context
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.paulina.examen2doparcialidgs903.Pregunta
import com.paulina.examen2doparcialidgs903.calcularEdad
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll


@Composable
fun PantallaExamen(
    navController: NavController,
    nombre: String,
    dia: Int,
    mes: Int,
    anio: Int,
    context: Context
) {
    val preguntas = listOf(
        Pregunta("¿Cuál es la suma de 2 + 2?", listOf("8", "6", "4", "3"), 2),
        Pregunta(
            "¿Cuál es la capital de Francia?",
            listOf("Londres", "Berlín", "París", "Madrid"),
            2
        ),
        Pregunta(
            "¿Qué planeta es el más cercano al sol?",
            listOf("Venus", "Mercurio", "Tierra", "Marte"),
            1
        ),
        Pregunta("¿Cuántos continentes hay?", listOf("5", "6", "7", "8"), 2),
        Pregunta(
            "¿Quién pintó la Mona Lisa?",
            listOf("Picasso", "Van Gogh", "Da Vinci", "Miguel Ángel"),
            2
        ),
        Pregunta(
            "¿Cuál es el lenguaje oficial de Brasil?",
            listOf("Español", "Portugués", "Inglés", "Francés"),
            1
        )
    )

    val respuestasSeleccionadas = remember { mutableStateMapOf<Int, Int>() }

    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    )
    {
        Text("Examen", style = MaterialTheme.typography.headlineMedium)

        preguntas.forEachIndexed { index, pregunta ->
            Card(modifier = Modifier.fillMaxWidth()) {
                Column(modifier = Modifier.padding(12.dp)) {
                    Text("${index + 1}. ${pregunta.texto}")
                    pregunta.opciones.forEachIndexed { opcionIndex, opcion ->
                        Row {
                            RadioButton(
                                selected = respuestasSeleccionadas[index] == opcionIndex,
                                onClick = { respuestasSeleccionadas[index] = opcionIndex }
                            )
                            Text("${'a' + opcionIndex}) $opcion")
                        }
                    }
                }
            }
        }

        Button(
            onClick = {
                val correctas =
                    respuestasSeleccionadas.count { it.value == preguntas[it.key].respuestaCorrecta }
                val calificacion = (correctas * 10) / preguntas.size
                val edad = calcularEdad(anio)
                val signo = determinarSignoChino(dia, mes, anio)

                guardarResultado(context, "$nombre,$edad,$signo,$calificacion")

                navController.navigate("resultados/$nombre/$edad/$signo/$calificacion")

            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Terminar Examen")
        }
    }
}