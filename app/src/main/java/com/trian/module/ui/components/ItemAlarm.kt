package com.trian.module.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Switch
import androidx.compose.material.SwitchColors
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.WbSunny
import androidx.compose.runtime.Composable
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
import com.trian.module.R
import com.trian.module.ui.theme.BackgroundCOlor
import com.trian.module.ui.theme.SelectedColor
import com.trian.module.ui.theme.Sunny
import com.trian.module.ui.theme.TextColor

@Composable
fun ItemAlarm(modifier: Modifier = Modifier){
    Column(
        modifier
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
            Text("Weekdays",style = TextStyle(fontSize = 24.sp,color = TextColor,fontFamily = FontFamily.Cursive))
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
                Switch(checked = false, onCheckedChange = {})
            }
            Spacer(modifier = modifier.height(4.dp))
            Text("Wake up",style = TextStyle(fontSize = 18.sp,color = TextColor))
        }

    }
}

@Preview
@Composable
fun PreviewItemAlarm(){
    ItemAlarm()
}