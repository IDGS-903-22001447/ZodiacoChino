package com.paulina.examen2doparcialidgs903

import android.content.Context
import java.io.*

class FileManager(private val context: Context) {
    private val fileName = "datos_usuario.txt"

    fun saveData(data: String) {
        try {
            context.openFileOutput(fileName, Context.MODE_PRIVATE).use {
                it.write(data.toByteArray())
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    fun readData(): String {
        return try {
            context.openFileInput(fileName).bufferedReader().useLines { lines ->
                lines.fold("") { acc, line -> acc + line }
            }
        } catch (e: FileNotFoundException) {
            ""
        } catch (e: IOException) {
            ""
        }
    }

    fun clearData() {
        context.deleteFile(fileName)
    }
}