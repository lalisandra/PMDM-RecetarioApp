package com.example.recetarioapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.recetarioapp.model.Dificultad
import com.example.recetarioapp.model.Receta
import com.example.recetarioapp.ui.theme.RecetarioAppTheme
import com.example.recetarioapp.ui.theme.screen.MainScreen
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RecetarioAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MainScreen(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                            .padding(8.dp),
                        recetas =  listOf(

                            Receta(
                                nombre = "Pasta Carbonara",
                                tiempo = 25,
                                dificultad = Dificultad.MEDIA,
                                descripcion = "La clásica receta italiana elaborada con huevo, queso parmesano, panceta y pimienta negra. Cremosa y llena de sabor."
                            ),

                            Receta(
                                nombre = "Ensalada César",
                                tiempo = 15,
                                dificultad = Dificultad.FACIL,
                                descripcion = "Lechuga romana, pollo a la plancha, picatostes y queso parmesano acompañados de la tradicional salsa César."
                            ),

                            Receta(
                                nombre = "Lasaña de Carne",
                                tiempo = 90,
                                dificultad = Dificultad.DIFICIL,
                                descripcion = "Capas de pasta fresca rellenas de carne picada, salsa de tomate y bechamel, gratinadas con abundante queso."
                            ),

                            Receta(
                                nombre = "Tortilla de Patatas",
                                tiempo = 40,
                                dificultad = Dificultad.MEDIA,
                                descripcion = "Uno de los platos más representativos de la cocina española, preparado con patatas, huevos y cebolla opcional."
                            ),

                            Receta(
                                nombre = "Salmón al Horno con Verduras",
                                tiempo = 35,
                                dificultad = Dificultad.FACIL,
                                descripcion = "Lomo de salmón horneado acompañado de calabacín, zanahoria y cebolla, aliñado con aceite de oliva y hierbas aromáticas."
                            )

                        )
                    )
                }
            }
        }
    }
}