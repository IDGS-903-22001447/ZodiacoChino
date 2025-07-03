package com.paulina.examen2doparcialidgs903

import android.content.Context
import java.io.OutputStreamWriter
import java.util.Calendar

fun calcularEdad(anio: Int): Int {
    val anioActual = Calendar.getInstance().get(Calendar.YEAR)
    return anioActual - anio
}
// funcion para determianr el signo chino
fun determinarSignoChino(dia: Int, mes: Int, anio: Int): String {
    val signos = listOf(
        "Rata", "Buey", "Tigre", "Conejo", "Dragón", "Serpiente",
        "Caballo", "Cabra", "Mono", "Gallo", "Perro", "Cerdo"
    )

    val fechasInicio = mapOf(
        2000 to Pair(5, 2),
        2001 to Pair(24, 1),
        2002 to Pair(12, 2),
        2003 to Pair(1, 2),
        2004 to Pair(22, 1),
        2005 to Pair(9, 2),
        2006 to Pair(29, 1),
        2007 to Pair(18, 2),
        2008 to Pair(7, 2),
        2009 to Pair(26, 1),
        2010 to Pair(14, 2)
    )


    val (inicioDia, inicioMes) = fechasInicio[anio] ?: return "Desconocido"

    val esAntesDelAñoNuevo = (mes < inicioMes) || (mes == inicioMes && dia < inicioDia)

    val anioZodiaco = if (esAntesDelAñoNuevo) anio - 1 else anio


    val indice = (anioZodiaco - 2000) % 12
    return signos[(indice + 4) % 12]
}

fun guardarResultado(context: Context, datos: String) {
    val file = OutputStreamWriter(context.openFileOutput("resultados.txt", Context.MODE_APPEND))
    file.write("$datos\n")
    file.close()
}