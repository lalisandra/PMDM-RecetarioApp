package com.example.recetarioapp.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
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
fun RecetaCard (
    modifier: Modifier,
    receta: Receta
){
    Card(
        modifier = modifier
    ) {
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Image(
                modifier = Modifier.size(64.dp),
                painter = painterResource(R.drawable.image_mockup),
                contentDescription = "Imagen Receta"
            )

            Column() {
                Text(text = receta.nombre, style = MaterialTheme.typography.titleLarge)
                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    horizontalArrangement = Arrangement.spacedBy(4.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        modifier = Modifier.size(24.dp),
                        painter = painterResource(R.drawable.timer_mockup),
                        contentDescription = "Tiempo"
                    )

                    Text(text = ": ${receta.tiempo}", style = MaterialTheme.typography.bodyMedium)

                    Spacer(modifier = Modifier.width(16.dp))

                    Image(
                        modifier = Modifier.size(24.dp),
                        painter = painterResource(R.drawable.difficulty_mockup),
                        contentDescription = "Dificultad"
                    )

                    Text(text = ": ${receta.dificultad}", style = MaterialTheme.typography.bodyMedium)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun RecetaCardPreview (){
    RecetaCard(
        modifier = Modifier,
        receta = Receta(
        nombre = "Nombre de la Receta",
        tiempo = 25,
        dificultad = Dificultad.MEDIA,
        descripcion = "La clásica receta italiana elaborada con huevo, queso parmesano, panceta y pimienta negra. Cremosa y llena de sabor."
    ))
}