package com.trian.module.ui.components


import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Close
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

/**
 * Entry point Activity of App
 * Author Trian Damai
 * Created at 03/09/2021
 * **/
@Composable
fun NewComposeAlarmAppbar(){
    TopAppBar(
        title = {},
        navigationIcon={
                       IconToggleButton(checked = false, onCheckedChange = {}) {
                           Icon( Icons.Outlined.Close, contentDescription = "Cancel")
                       }
        },
        actions={
                TextButton(onClick = { /*TODO*/ }) {
                    Text(text = "Save")
                }
        },
        backgroundColor = Color.Transparent,elevation = 0.dp
    )
}

