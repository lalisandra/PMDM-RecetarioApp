package com.example.recetarioapp.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SegmentedButtonDefaults
import androidx.compose.material3.SingleChoiceSegmentedButtonRow
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.recetarioapp.model.Dificultad
import com.example.recetarioapp.model.Receta
import com.example.recetarioapp.validacion.RecetaFormValidator

@Composable
fun RecetaFormScreen(
    modifier: Modifier,
    recetaInicial: Receta?,
    onSaveClick: (Receta) -> Unit,
    onCancelarClick: () -> Unit
){
    val dificultadOptions = listOf(
        Dificultad.FACIL,
        Dificultad.MEDIA,
        Dificultad.DIFICIL
    )

    var nombre by remember {
        mutableStateOf(recetaInicial?.nombre ?: "")
    }

    var tiempo by remember {
        mutableStateOf(recetaInicial?.tiempo?.toString() ?: "")
    }

    var dificultadIndex by remember {
        mutableIntStateOf(dificultadOptions.indexOf(recetaInicial?.dificultad).coerceAtLeast(0))
    }

    var descripcion by remember  {
        mutableStateOf(recetaInicial?.descripcion ?: "")
    }
    //Si la receta no es nula (estamos editando una receta) cargamos las variables con sus datos
    //si lo es (nueva receta) los inicializamos "vacios"

    var errorNombre by remember { mutableStateOf<String?>(null) }
    var errorTiempo by remember { mutableStateOf<String?>(null) }
    //Variables de validación

    Column(
        modifier = modifier
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth(),
            value = nombre,
            onValueChange = {nombre = it},
            label = { Text("Nombre") },
            isError = errorNombre != null,
            supportingText = { errorNombre?.let { Text(text = it, color = MaterialTheme.colorScheme.error) } }

        )

        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth(),
            value = tiempo,
            onValueChange = {tiempo = it },
            label = { Text("Tiempo (min)") },
            isError = errorTiempo != null,
            supportingText = { errorTiempo?.let { Text(text = it, color = MaterialTheme.colorScheme.error) }}

        )

        Text("Dificultad")

        SingleChoiceSegmentedButtonRow(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            dificultadOptions.forEachIndexed { index, label ->
                SegmentedButton(
                    shape = SegmentedButtonDefaults.itemShape(
                        index = index,
                        count = dificultadOptions.size
                    ),
                    onClick = { dificultadIndex = index },
                    selected = index == dificultadIndex,
                    label = { Text(label) }
                )
            }
        }

        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            value = descripcion,
            onValueChange = {descripcion = it},
            label = { Text("Descripción") }

        )

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.End)
        ) {

            TextButton (
                onClick = {
                    onCancelarClick()
                }
            ) {
                Text("Cancelar")
            }

            Button(
                onClick = {

                    errorNombre = RecetaFormValidator.validarNombre(nombre)
                    errorTiempo = RecetaFormValidator.validarTiempo(tiempo)
                    //Faltan el resto de Validaciones

                    if (errorNombre == null && errorTiempo == null) {
                        onSaveClick(
                            Receta(
                                id = recetaInicial?.id ?: 0,
                                nombre = nombre,
                                tiempo = tiempo.toInt(),
                                dificultad = dificultadOptions[dificultadIndex],
                                descripcion = descripcion
                            )
                        )
                    }
                }
            ) {
                Text("Guardar")
            }
        }


    }
}


@Preview(showBackground = true)
@Composable
fun RecetaFormScreenPreview(){

    RecetaFormScreen(
        modifier = Modifier.fillMaxSize(),
        onSaveClick = { },
        onCancelarClick = { },
        recetaInicial = null
    )
}