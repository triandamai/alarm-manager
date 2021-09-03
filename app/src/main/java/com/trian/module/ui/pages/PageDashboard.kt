package com.trian.module.ui.pages

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.trian.common.utils.route.Routes
import com.trian.domain.entities.Alarm
import com.trian.module.MainViewModel
import com.trian.module.ui.components.BottomFloatingAction
import com.trian.module.ui.components.ItemAlarm
import com.trian.module.ui.components.MainAppBar
import com.trian.module.ui.theme.BackgroundCOlor
import com.trian.module.ui.theme.TextColor
import kotlinx.coroutines.CoroutineScope

/**
 * Dashboard
 * Author Trian Damai
 * Created at 03/09/2021
 * **/
@Composable
fun PageDashboard(viewModel:MainViewModel,nav:NavHostController,scope:CoroutineScope){
    val alarms by viewModel.getListAlarms().observeAsState()
    Scaffold(
        topBar = {MainAppBar()},
        bottomBar ={ BottomFloatingAction(onNewAlarm = { nav.navigate(Routes.COMPOSE.name) })},
        backgroundColor = BackgroundCOlor ) {
        alarms?.let {
            ComponentDashboard( alarms = it)
        } ?: run {
            Column {
                Text(text = "Empty State")
            }
        }
    }
}

@Composable
fun ComponentDashboard(alarms:List<Alarm>,modifier: Modifier=Modifier){
      Column( modifier=modifier.padding(start = 16.dp,end = 16.dp),) {
            Text("Upcoming Alarm",style = TextStyle(fontSize = 18.sp,color = TextColor))
            LazyColumn(
                content ={
                    items(count = alarms.size,itemContent = {
                            index ->
                        Spacer(modifier = modifier.height(10.dp))
                        ItemAlarm(alarms[index],index,
                            onAlarmToggle = {alarm, index ->

                        },
                            onAlarmClicked = {alarm, index ->

                            }
                        )
                    })
                })
        }
}

@Preview
@Composable
fun PreviewComponentDashboard(){
    ComponentDashboard(alarms = listOf())
}