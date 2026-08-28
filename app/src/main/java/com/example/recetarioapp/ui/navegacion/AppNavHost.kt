package com.example.recetarioapp.ui.navegacion

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.recetarioapp.model.Dificultad
import com.example.recetarioapp.model.Receta
import com.example.recetarioapp.ui.screen.DetalleScreen
import com.example.recetarioapp.ui.screen.HomeScreen
import com.example.recetarioapp.ui.screen.PerfilScreen
import com.example.recetarioapp.ui.theme.screen.ListaRecetasScreen

object Rutas {
    const val HOME = "home"
    const val RECETAS = "recetas"
    const val DETALLE = "detalle/{recetaId}"
    const val PERFIL = "perfil"

    fun detalleConId(recetaId: Long) = "detalle/$recetaId"
}

@Composable
fun AppNavHost (
    navController: NavHostController,
    modifier: Modifier
){
    val listarecetas = listOf(

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

    NavHost(
        navController = navController,
        startDestination = Rutas.HOME,
        modifier = modifier
    ){
        composable(Rutas.HOME) {
            HomeScreen(
                modifier = Modifier,
                recetas = listarecetas,
                onFavRecetaClick = { navController.navigate(Rutas.detalleConId(it))}
            )
        }

        composable(Rutas.RECETAS) {
            ListaRecetasScreen(
                modifier = Modifier,
                recetas = listarecetas,
                onRecetaClick = { navController.navigate(Rutas.detalleConId(it)) }
            )
        }

        composable (Rutas.PERFIL) {
            PerfilScreen(
                modifier = Modifier
            )
        }

        composable (
            route = Rutas.DETALLE,
            arguments = listOf(navArgument("recetaId") { type = NavType.LongType })
        ) {
            DetalleScreen(
                modifier = Modifier,
                receta = buscarReceta(it.arguments?.getLong("recetaId")!!)
            )
        }
    }
}

fun buscarReceta(id: Long) : Receta {

    val listarecetas = listOf(

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

    return listarecetas.find { it.id == id }!!
}