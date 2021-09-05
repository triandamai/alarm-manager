package com.trian.module.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.trian.module.ui.theme.SelectedColor

@Composable
fun ItemRepeatDays(modifier: Modifier = Modifier,selected:Boolean,index:Int,onClick:(index:Int)->Unit){
    var selecteddays by remember {
        mutableStateOf(selected)
    }
    Column(modifier = modifier
        .clickable { onClick(index) }
        .wrapContentWidth()
        .padding(start = 3.dp,end = 3.dp)
        .clip(RoundedCornerShape(4.dp))
        .background(color= when(selecteddays){
            true -> SelectedColor
            else -> Color.White
        })
        .height(40.dp)) {
        Text(text = index.getDaysName(),style = TextStyle(color = when(selecteddays){
            true -> Color.White
            else -> SelectedColor
        }),modifier = modifier.padding(horizontal = 4.dp,vertical = 10.dp))
    }
}

@Preview
@Composable
fun PreviewItemRepeatDays(){
    ItemRepeatDays(selected = false,index=0,onClick={index:Int->})
}

fun Int.getDaysName():String{
    if(this == 0){
        return "Mon"
    }
    if(this == 1){
        return "Tue"
    }
    if(this == 2){
        return "Wed"
    }
    if(this == 3){
        return  "Thu"
    }
    if(this == 4){
        return "Fri"
    }
    if(this == 5){
        return "Sat"
    }
    if(this == 6){
        return "Sun"
    }
    return "Unknown"
}