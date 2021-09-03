package com.trian.module.ui.pages

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.trian.module.ui.components.MyNumberPicker
import com.trian.module.ui.components.NewComposeAlarmAppbar
import com.trian.module.ui.theme.BackgroundCOlor
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
    Scaffold(
        topBar = {
            NewComposeAlarmAppbar()
        },
        bottomBar = {

        },
        backgroundColor = BackgroundCOlor
    ) {
        Column {
            Column {
                Row {
                    MyNumberPicker(10,100,onValueChange = {old, new ->  })
                    MyNumberPicker(10,100,onValueChange = {old, new ->  })
                }
            }
        }
    }
}
@Preview
@Composable
fun PreviewPageNewAlarm(){
    PageNewAlarm(nav = rememberNavController(), scope = rememberCoroutineScope() )
}