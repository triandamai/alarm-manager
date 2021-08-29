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
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.trian.module.ui.theme.SelectedColor

@Composable
fun BottomFloatingAction(modifier: Modifier=Modifier){
    Row(modifier = modifier.fillMaxWidth().padding(top = 5.dp,bottom = 10.dp),horizontalArrangement = Arrangement.Center) {
       FloatingActionButton(onClick = { /*TODO*/ },backgroundColor = SelectedColor) {
           IconToggleButton(checked = false, onCheckedChange = {}) {
               Icon(Icons.Outlined.Add,contentDescription = "",tint = Color.White)
           }
       } 
    }
}

@Preview
@Composable
fun PreviewFloatingAction(){
    BottomFloatingAction()
}