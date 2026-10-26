package com.example.recetarioapp.ui.navegacion

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.recetarioapp.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyAppTopBar (
    navController: NavController
) {

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    val recetaId = navBackStackEntry?.arguments?.getLong("recetaId")
    //Si estoy en una ruta con recetaId en su ruta lo extrae, si no, es null

    TopAppBar(
        title = {
            Text( text =
                when (currentRoute) {
                    Rutas.HOME -> "Recetario App"
                    Rutas.DETALLE -> "Receta"
                    Rutas.PERFIL -> "Mi perfil"
                    Rutas.RECETAS -> "Todas mis recetas"
                    Rutas.NUEVA_RECETA -> "Nueva Receta"
                    Rutas.EDITAR_RECETA -> "Editar Receta"
                    else -> ""
                },
                style = MaterialTheme.typography.headlineLarge
            )
        },
        navigationIcon = {
            if(currentRoute != Rutas.HOME) {
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(painter = painterResource(R.drawable.arrow_back), contentDescription = "Volver" )
                }
            }
        },
        actions = {
            if(currentRoute == Rutas.DETALLE && recetaId != null) {
                IconButton( onClick = { navController.navigate(Rutas.recetaFormConId(recetaId)) } ) {
                    Icon(painter = painterResource(R.drawable.edit_icon), contentDescription = "edit" )
                }
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer
        )
    )

}