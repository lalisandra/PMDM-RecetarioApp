package com.example.recetarioapp.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.recetarioapp.R

@Composable
fun PerfilScreen (
    modifier: Modifier
) {
    Column(
        modifier = modifier,
    ) {

        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.3f, true),
            color = MaterialTheme.colorScheme.secondaryContainer
        ) {

            Column(
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    modifier = Modifier
                        .weight(0.7f)
                        .aspectRatio(1f)
                        .clip(CircleShape)
                        .border(
                            width = 8.dp,
                            color = MaterialTheme.colorScheme.primary,
                            shape = CircleShape
                        ),
                    painter = painterResource(R.drawable.naruto),
                    contentDescription = "Foto perfil",
                    contentScale = ContentScale.Crop
                )
                Spacer( modifier = Modifier.weight(0.1f) )
                Text(
                    modifier = Modifier
                        .weight(0.2f),
                    text = "Naruto Uzumaki",
                    style = MaterialTheme.typography.headlineLarge,
                )
            }

        }

        Surface(
            modifier = Modifier
                .weight(0.7f)
        ){
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Text("Dirección: C/Ramen 25, Konoha", style = MaterialTheme.typography.bodyLarge)
                Text("Tlf: +52 999999999", style = MaterialTheme.typography.bodyLarge)
                Text("45 recetas registradas", style = MaterialTheme.typography.bodyLarge)
            }

        }

    }
}


@Preview(showBackground = true)
@Composable
fun PerfilScreenPreview(){
    PerfilScreen(
        modifier = Modifier.fillMaxSize()
    )
}