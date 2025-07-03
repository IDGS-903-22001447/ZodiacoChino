package com.paulina.examen2doparcialidgs903

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun Navigation(navController: NavHostController, context: Context) {
    NavHost(navController = navController, startDestination = "formulario") {
        composable("formulario") {
            PantallaFormulario(navController, context)
        }
        composable("examen/{nombre}/{dia}/{mes}/{anio}") { backStackEntry ->
            val nombre = backStackEntry.arguments?.getString("nombre") ?: ""
            val dia = backStackEntry.arguments?.getString("dia")?.toIntOrNull() ?: 1
            val mes = backStackEntry.arguments?.getString("mes")?.toIntOrNull() ?: 1
            val anio = backStackEntry.arguments?.getString("anio")?.toIntOrNull() ?: 2000

            PantallaExamen(navController, nombre, dia, mes, anio, context)
        }
        composable("resultados/{nombre}/{edad}/{signo}/{calificacion}") { backStackEntry ->
            val nombre = backStackEntry.arguments?.getString("nombre") ?: ""
            val edad = backStackEntry.arguments?.getString("edad")?.toInt() ?: 0
            val signo = backStackEntry.arguments?.getString("signo") ?: ""
            val calificacion = backStackEntry.arguments?.getString("calificacion")?.toInt() ?: 0
            PantallaResultados(nombre, edad, signo, calificacion)
        }
    }
}