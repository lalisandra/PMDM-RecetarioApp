package com.example.recetarioapp.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.recetarioapp.R
import com.example.recetarioapp.model.Dificultad
import com.example.recetarioapp.model.Receta

@Composable
fun DetalleScreen(
    modifier: Modifier,
    receta: Receta
){
    Column(
        modifier = modifier,
    ) {

        Surface(
            modifier = Modifier
                .fillMaxWidth(),
            color = MaterialTheme.colorScheme.secondaryContainer
        ) {
            Column(
                modifier = Modifier
                    .padding(12.dp)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {

                Image(
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(1f),
                    painter = painterResource(R.drawable.image_mockup),
                    contentDescription = "Imagen Receta"
                )

                Text(
                    modifier = Modifier
                        .fillMaxWidth(),
                    text = receta.nombre,
                    style = MaterialTheme.typography.displaySmall,
                    color = MaterialTheme.colorScheme.onSecondaryContainer,
                    maxLines = 2,
                )

                Row(
                    horizontalArrangement = Arrangement.spacedBy(4.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        modifier = Modifier.size(48.dp),
                        painter = painterResource(R.drawable.timer_mockup),
                        contentDescription = "Tiempo"
                    )

                    Text(text = ": ${receta.tiempo}", style = MaterialTheme.typography.headlineMedium)

                    Spacer(modifier = Modifier.width(16.dp))

                    Image(
                        modifier = Modifier.size(48.dp),
                        painter = painterResource(R.drawable.difficulty_mockup),
                        contentDescription = "Dificultad"
                    )

                    Text(text = ": ${receta.dificultad}", style = MaterialTheme.typography.headlineMedium)
                }

            }

        }

        Surface(
            modifier = Modifier
                .fillMaxSize()

        ){

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(12.dp)
                    .verticalScroll(rememberScrollState())
            ) {
                Text(
                    text = receta.descripcion,
                    style = MaterialTheme.typography.bodyLarge
                )
            }


        }

    }

}

@Preview
@Composable
fun DetalleScreenPreview(){
    DetalleScreen(
        modifier = Modifier,
        receta = Receta(
                id = 1,
                nombre = "Pasta Carbonara",
                tiempo = 25,
                dificultad = Dificultad.MEDIA,
                descripcion = "La clásica receta italiana elaborada con huevo, queso parmesano, panceta y pimienta negra. Cremosa y llena de sabor."
        )
    )
}