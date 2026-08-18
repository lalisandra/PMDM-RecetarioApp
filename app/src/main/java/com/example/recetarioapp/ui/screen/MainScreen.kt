package com.example.recetarioapp.ui.theme.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
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
fun MainScreen (
    modifier: Modifier,
    recetas: List<Receta>
){
    Column(
        modifier = modifier
    ) {

        Text(text = "Recetario APP", style = MaterialTheme.typography.displaySmall)

        Spacer(modifier = Modifier.height(8.dp))

        RecetasList(
            modifier = Modifier.fillMaxWidth(),
            recetas = recetas
        )

    }
}

@Composable
fun RecetasList(
    modifier: Modifier,
    recetas: List<Receta>
){
    LazyColumn(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(20){
            RecetaCard(
                modifier = Modifier.fillMaxWidth(),
                receta = recetas.random())
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RecetaListPreview(){
    RecetasList(
        modifier = Modifier,
        recetas = listOf(
            Receta( nombre = "Receta I", tiempo = 5, dificultad = Dificultad.FACIL, descripcion = " " ),
            Receta( nombre = "Receta II", tiempo = 15, dificultad = Dificultad.MEDIA, descripcion = " " ),
            Receta( nombre = "Receta III", tiempo = 25, dificultad = Dificultad.DIFICIL, descripcion = " " )
        )
    )
}