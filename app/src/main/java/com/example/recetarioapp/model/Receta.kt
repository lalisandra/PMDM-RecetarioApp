package com.example.recetarioapp.model

object Dificultad {
    const val FACIL = "Fácil"
    const val MEDIA = "Media"
    const val DIFICIL = "Difícil"
}

data class Receta (

    val id: Long,
    val nombre: String,
    val tiempo: Int,            //tiempo en minutos
    val dificultad: String,

    val descripcion: String

)