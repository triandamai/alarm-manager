package com.trian.module.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.WbSunny
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.trian.domain.entities.Alarm
import com.trian.module.R
import com.trian.module.ui.theme.*
/**
 * Entry point Activity of App
 * Author Trian Damai
 * Created at 03/09/2021
 * **/
@Composable
fun ItemAlarm(alarm:Alarm,index:Int,onAlarmClicked:(alarm:Alarm,index:Int)->Unit,onAlarmToggle:(alarm:Alarm,index:Int)->Unit,modifier: Modifier = Modifier){
    var enable by remember{ mutableStateOf(false)}
    Column(
        modifier
            .clickable { onAlarmClicked(alarm, index) }
            .clip(RoundedCornerShape(10.dp))
            .background(Color.White)
            .padding(vertical = 8.dp, horizontal = 16.dp)
            .fillMaxWidth()) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Column(modifier = modifier
                .clip(CircleShape)
                .height(10.dp)
                .width(10.dp)
                .background(SelectedColor)){}
            Spacer(modifier = modifier.width(8.dp))
            Text("Weekdays",style = TextStyle(fontSize = 24.sp,color = TextColor,fontFamily = FontFamily.Default))
        }
        Column(modifier = modifier.padding(start = 8.dp)) {
            Spacer(modifier = modifier.height(6.dp))
            Row(horizontalArrangement = Arrangement.SpaceBetween,modifier = modifier.fillMaxWidth()) {
                Row {
                    Text(text = "04:00",style = TextStyle(fontSize = 71.sp,color = TextColor,fontWeight = FontWeight.Light))
                    Spacer(modifier = modifier.width(12.dp))
                    Column {
                        Icon(
                            Icons.Outlined.WbSunny,
                            contentDescription = null,
                            tint = Sunny,
                            modifier = modifier
                                .height(30.dp)
                                .width(30.dp)
                        )
                        Text(text = "PM",style = TextStyle(fontSize = 40.sp,color = TextColor,fontWeight = FontWeight.Light))
                    }
                }
                Switch(checked = enable, onCheckedChange = {
                    enable = it
                    onAlarmToggle(alarm,index)
                },
                colors = SwitchDefaults.colors(
                    checkedThumbColor = SelectedColor,
                    checkedTrackColor = SelectedColorTrack
                )

                )
            }
            Spacer(modifier = modifier.height(4.dp))
            Text("Wake up",style = TextStyle(fontSize = 18.sp,color = TextColor))
        }

    }
}

@Preview
@Composable
fun PreviewItemAlarm(){
    ItemAlarm(alarm = Alarm(
        0,
        0,
        0,
        false,
        false,
        false,
        false,
        false,
        false,
        false,
        false,
        false,
        ""
    ),
        onAlarmClicked = {alarm, index ->  },
        onAlarmToggle = {alarm, index ->  },
        index = 0,
    )
}