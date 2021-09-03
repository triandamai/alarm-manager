package com.trian.module.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.IconToggleButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.trian.module.ui.theme.SelectedColor
/**
 * Entry point Activity of App
 * Author Trian Damai
 * Created at 03/09/2021
 * **/
@Composable
fun BottomFloatingAction(modifier: Modifier=Modifier,onNewAlarm:()->Unit){
    var enable by remember{ mutableStateOf(false)}
    Row(modifier = modifier.fillMaxWidth().padding(top = 5.dp,bottom = 10.dp),horizontalArrangement = Arrangement.Center) {
       FloatingActionButton(onClick = onNewAlarm,backgroundColor = SelectedColor) {
           IconToggleButton(checked = enable, onCheckedChange = {onNewAlarm()}) {
               Icon(Icons.Outlined.Add,contentDescription = "Compose New Alarm",tint = Color.White)
           }
       } 
    }
}

@Preview
@Composable
fun PreviewFloatingAction(){
    BottomFloatingAction(onNewAlarm = {})
}