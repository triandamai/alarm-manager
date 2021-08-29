package com.trian.module.ui.components

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.trian.module.ui.theme.TextColor

@Composable
fun MainAppBar(){
    TopAppBar (
        title = {
            Text("My Alarm",style =  TextStyle(fontSize = 18.sp,color = TextColor,fontWeight = FontWeight.Light))
        },
        actions = {
            IconToggleButton(checked =false, onCheckedChange ={}) {
                Icon(Icons.Outlined.Menu,contentDescription = "")
            }
        },
        backgroundColor = Color.White,
        elevation = 0.dp
    )
}

@Preview
@Composable
fun PreviewMainAppbar(){
    MainAppBar()
}