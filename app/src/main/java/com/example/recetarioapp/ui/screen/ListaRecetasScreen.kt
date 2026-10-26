package com.example.recetarioapp.ui.theme.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

import com.example.recetarioapp.model.Dificultad
import com.example.recetarioapp.model.Receta
import com.example.recetarioapp.ui.components.RecetaCard


@Composable
fun ListaRecetasScreen (
    modifier: Modifier,
    recetas: List<Receta>,
    onRecetaClick: (Long) -> Unit,
    onNuevaRecetaClick: () -> Unit
){
    Column(
        modifier = modifier
            .padding(12.dp)
    ) {
        RecetasList(
            modifier = Modifier.fillMaxWidth(),
            recetas = recetas,
            onRecetaClick = { onRecetaClick(it) },
            onNuevaRecetaClick = { onNuevaRecetaClick() }
        )
    }
}

@Composable
fun RecetasList(
    modifier: Modifier,
    recetas: List<Receta>,
    onRecetaClick: (Long) -> Unit,
    onNuevaRecetaClick: () -> Unit
){
    Column(

    ) {
        LazyColumn(
            modifier = modifier,
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            item {
                ElevatedCard (
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 6.dp
                    ),
                    modifier = Modifier
                        .fillMaxWidth(),
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.primaryContainer
                    ),
                    onClick = { onNuevaRecetaClick() }
                ) {
                    Text(
                        modifier = Modifier
                            .padding(8.dp)
                            .padding(
                                top = 12.dp,
                                bottom = 12.dp,
                            ),
                        text = "Nueva Receta",
                        style = MaterialTheme.typography.headlineLarge
                    )
                }
            }
             items(recetas){ receta ->
                 RecetaCard(
                     modifier = Modifier,
                     receta = receta,
                     onClick = { onRecetaClick(receta.id)}
                 )
             }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RecetaListPreview(){
    RecetasList(
        modifier = Modifier,
        recetas = listOf(
            Receta( id = 0, nombre = "Receta I", tiempo = 5, dificultad = Dificultad.FACIL, descripcion = " " ),
            Receta( id = 0, nombre = "Receta II", tiempo = 15, dificultad = Dificultad.MEDIA, descripcion = " " ),
            Receta( id = 0, nombre = "Receta III", tiempo = 25, dificultad = Dificultad.DIFICIL, descripcion = " " )
        ),
        onRecetaClick = { },
        onNuevaRecetaClick = { }
    )
}