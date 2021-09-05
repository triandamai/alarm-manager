package com.trian.module.ui.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.trian.module.ui.components.ItemRepeatDays
import com.trian.module.ui.components.MyNumberPicker
import com.trian.module.ui.components.NewComposeAlarmAppbar
import com.trian.module.ui.components.PreviewItemRepeatDays
import com.trian.module.ui.theme.BackgroundColor
import com.trian.module.ui.theme.SelectedColor
import com.trian.module.ui.theme.SelectedColorTrack
import kotlinx.coroutines.CoroutineScope
/**
 * Create New Alarm
 * Author Trian Damai
 * Created at 03/09/2021
 * **/
@Composable
fun PageNewAlarm(nav:NavHostController,scope:CoroutineScope){
    ComponentNewAlarm()
}
@Composable
fun ComponentNewAlarm(modifier: Modifier = Modifier){
    var alarm_name by remember{
        mutableStateOf("")
    }
    var sliderPosition by remember {
        mutableStateOf(0f)
    }

    Scaffold(
        topBar = {
            NewComposeAlarmAppbar()
        },
        bottomBar = {

        },
        backgroundColor = BackgroundColor
    ) {
        Column(modifier = modifier
            .background(BackgroundColor)
            .padding(vertical = 16.dp, horizontal = 16.dp)) {
            Column(modifier = modifier
                .fillMaxWidth()
                .height(200.dp)
                .background(Color.White)
                .padding(start = 10.dp, end = 10.dp, top = 10.dp, bottom = 10.dp),horizontalAlignment = Alignment.CenterHorizontally) {
                Row(modifier = modifier.fillMaxWidth(),horizontalArrangement = Arrangement.SpaceEvenly,verticalAlignment = Alignment.CenterVertically) {
                    MyNumberPicker(0,24,onValueChange = {old, new ->  })
                    Text(":",style = TextStyle(fontSize = 30.sp))
                    MyNumberPicker(0,60,onValueChange = {old, new ->  })
                }

            }
            //header section repeat
            Row(modifier = modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp),horizontalArrangement = Arrangement.SpaceBetween,verticalAlignment = Alignment.CenterVertically) {
                Text(text = "Repeat")
                Text(text = "Weekdays")
            }

            //item repeat
            LazyRow{
                items(count = 7,itemContent = {index: Int ->
                    ItemRepeatDays( selected = false, index = index, onClick = {idx ->  })
                })
            }

            //alarm name
            Text(text = "Alarm Name")
            TextField(
                modifier =modifier.fillMaxWidth().background(Color.Transparent),
                value = alarm_name, onValueChange = {alarm_name = it})
            //alarm sound
            //header section repeat
            Row(modifier = modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp),horizontalArrangement = Arrangement.SpaceBetween,verticalAlignment = Alignment.CenterVertically) {
                Text(text = "Alarm Sound")
                Text(text = "Default")
            }
            //alarm volume
            Text(text = "Alarm Volume")
            Slider(
                value = sliderPosition,
                onValueChange = { sliderPosition = it },
                valueRange = 0f..100f,
                onValueChangeFinished = {
                    // launch some business logic update with the state you hold
                    // viewModel.updateSelectedSliderValue(sliderPosition)
                },
                steps = 5,
                colors = SliderDefaults.colors(
                    thumbColor = SelectedColor,
                    activeTrackColor = SelectedColorTrack,
                    inactiveTrackColor = Color.LightGray
                )
            )
        }

    }
}
@Preview
@Composable
fun PreviewPageNewAlarm(){
    PageNewAlarm(nav = rememberNavController(), scope = rememberCoroutineScope() )
}