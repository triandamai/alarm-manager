package com.trian.module.ui.pages

import android.annotation.SuppressLint
import android.os.Handler
import android.os.Looper
import androidx.compose.foundation.layout.Column
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.trian.common.utils.route.Routes
import com.trian.module.ui.components.MyTimePicker
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.*
import kotlin.concurrent.schedule
/**
 * Splash Screen Page
 * Author Trian Damai
 * Created at 03/09/2021
 * **/
@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun PageSplashScreen(
    nav:NavHostController,
    scope:CoroutineScope,
    modifier: Modifier = Modifier,
    scaffoldState: ScaffoldState = rememberScaffoldState(),
            onDatePicker:(hour:Int,minute:Int)->Unit,
) {
var hours by remember{ mutableStateOf(0)}
var minutes by remember{ mutableStateOf(0)}
//    Handler(Looper.getMainLooper())
//        .postDelayed({
//            nav.navigate(Routes.ONBOARD.name)
//    },1000)
    Column {
        Text(text = "Ini Splash")
        Button(onClick = { onDatePicker(hours,minutes) }) {
            Text(text = "Ini Splash")
        }
        MyTimePicker(onDatePicker = {
           hour, minute->
            minutes =minute
            hours = hour
        })
    }


}
