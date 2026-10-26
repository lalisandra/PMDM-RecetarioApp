package com.example.recetarioapp.validacion

object RecetaFormValidator {
    fun validarNombre(nombre: String): String? {
        return if (nombre.isBlank()) {
            "El nombre es obligatorio"
        } else { null }
    }
    fun validarTiempo(tiempo: String): String? {
        val minutos = tiempo.toIntOrNull()
        return when {
            minutos == null -> "Introduce un número válido"
            minutos <= 0 -> "El tiempo debe ser mayor que cero"
            else -> null
        }
    }

}