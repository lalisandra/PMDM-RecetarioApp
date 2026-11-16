package com.example.recetarioapp.model

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

interface RecetaRepository {

    fun getAllRecetas(): Flow<List<Receta>>
    fun getRecetaId(recetaId: Long): Receta?
    fun addReceta(receta: Receta):Boolean
    fun updateReceta(receta: Receta):Boolean
    fun deleteReceta(receta: Receta):Boolean

}

class InMemoryRecetaRepository: RecetaRepository {

    private val _listaReceta = MutableStateFlow(
        listOf(
            Receta(
                id = 1,
                nombre = "Pasta Carbonara",
                tiempo = 25,
                dificultad = Dificultad.MEDIA,
                descripcion = "La clásica receta italiana elaborada con huevo, queso parmesano, panceta y pimienta negra. Cremosa y llena de sabor."
            ),

            Receta(
                id = 2,
                nombre = "Ensalada César",
                tiempo = 15,
                dificultad = Dificultad.FACIL,
                descripcion = "Lechuga romana, pollo a la plancha, picatostes y queso parmesano acompañados de la tradicional salsa César."
            ),

            Receta(
                id = 3,
                nombre = "Lasaña de Carne",
                tiempo = 90,
                dificultad = Dificultad.DIFICIL,
                descripcion = "Capas de pasta fresca rellenas de carne picada, salsa de tomate y bechamel, gratinadas con abundante queso."
            ),

            Receta(
                id = 4,
                nombre = "Tortilla de Patatas",
                tiempo = 40,
                dificultad = Dificultad.MEDIA,
                descripcion = "Uno de los platos más representativos de la cocina española, preparado con patatas, huevos y cebolla opcional."
            ),

            Receta(
                id = 5,
                nombre = "Salmón al Horno con Verduras",
                tiempo = 35,
                dificultad = Dificultad.FACIL,
                descripcion = "Lomo de salmón horneado acompañado de calabacín, zanahoria y cebolla, aliñado con aceite de oliva y hierbas aromáticas."
            )
        )
    )

    override fun getAllRecetas(): Flow<List<Receta>> {
        return _listaReceta
    }

    override fun getRecetaId(recetaId: Long): Receta? {
        return _listaReceta.value.find { it.id == recetaId }
    }

    override fun addReceta(receta: Receta): Boolean {
        val indice = _listaReceta.value.indexOfFirst { it.id == receta.id }

        if (indice == -1) {
            _listaReceta.value = _listaReceta.value + receta
            return true
        }
        return false
    }

    override fun updateReceta(receta: Receta): Boolean {
        val indice = _listaReceta.value.indexOfFirst { it.id == receta.id }

        if (indice != -1) {
            _listaReceta.value = _listaReceta.value.map { if (it.id == receta.id) receta else it }
            return true
        }
        return false
    }

    override fun deleteReceta(receta: Receta): Boolean {
        val indice = _listaReceta.value.indexOfFirst { it.id == receta.id }

        if (indice != -1) {
            _listaReceta.value = _listaReceta.value.filter { it.id != receta.id }
            return true
        }
        return false
    }


}