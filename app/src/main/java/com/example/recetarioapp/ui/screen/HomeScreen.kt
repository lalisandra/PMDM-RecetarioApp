package com.example.recetarioapp.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.snapping.SnapPosition
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.recetarioapp.R
import com.example.recetarioapp.model.Dificultad
import com.example.recetarioapp.model.Receta

@Composable
fun HomeScreen (
    modifier: Modifier,
    recetas: List<Receta>,
    onFavRecetaClick: (Long) -> Unit
) {
    Surface() {
        Column(
            modifier = modifier
                .padding(12.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {

            FavScroll(
                modifier = Modifier.fillMaxWidth(),
                recetas = recetas,
                onRecetaClick = { onFavRecetaClick(it) }
            )

        }
    }
}

@Composable
fun FavScroll (
    modifier: Modifier,
    recetas: List<Receta>,
    onRecetaClick: (Long) -> Unit
) {
    Column(
        modifier = modifier,
    ) {

        Row (
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                modifier = Modifier.size(40.dp),
                painter = painterResource(R.drawable.favorite_icon),
                colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.primary),
                contentDescription = "Fav Icon")
            Spacer(Modifier.width(8.dp))
            Text( text = "Mis recetas favoritas:", style = MaterialTheme.typography.titleLarge)
        }
        HorizontalDivider()

        LazyRow(
            modifier = Modifier.padding(4.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(recetas) {
                RecetaHomeCard(
                    modifier = Modifier,
                    receta = it,
                    onClick = { onRecetaClick(it) }
                )
            }
            items(recetas) {
                RecetaHomeCard(
                    modifier = Modifier,
                    receta = it,
                    onClick = { onRecetaClick(it) }
                )
            }
            items(recetas) {
                RecetaHomeCard(
                    modifier = Modifier,
                    receta = it,
                    onClick = { onRecetaClick(it) }
                )
            }
        }
    }
}

@Composable
fun RecetaHomeCard(
    modifier: Modifier,
    receta: Receta,
    onClick: (Long) -> Unit
){
    Card (
        modifier = modifier
            .width(140.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.secondaryContainer
        ),
        onClick = { onClick(receta.id)}
    ) {
        Column(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Image(
                modifier = Modifier.size(120.dp),
                painter = painterResource(R.drawable.image_mockup),
                contentDescription = "Receta"
            )

            Spacer(Modifier.height(4.dp))

            Text(
                modifier = Modifier.height(48.dp),
                text = receta.nombre,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Preview (showBackground = true)
@Composable
fun HomeScreenPreview (){
    val recetas = listOf(
        Receta( id = 0, nombre = "Receta I", tiempo = 5, dificultad = Dificultad.FACIL, descripcion = " " ),
        Receta( id = 0, nombre = "Receta II", tiempo = 15, dificultad = Dificultad.MEDIA, descripcion = " " ),
        Receta( id = 0, nombre = "Receta III", tiempo = 25, dificultad = Dificultad.DIFICIL, descripcion = " " )
    )

    HomeScreen(
        modifier = Modifier,
        recetas = recetas,
        onFavRecetaClick = { }
    )
}