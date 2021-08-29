package com.trian.module.ui.pages

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.trian.module.ui.components.BottomFloatingAction
import com.trian.module.ui.components.ItemAlarm
import com.trian.module.ui.components.MainAppBar
import com.trian.module.ui.theme.BackgroundCOlor
import com.trian.module.ui.theme.TextColor
import kotlinx.coroutines.CoroutineScope


@Composable
fun PageDashboard(nav:NavHostController,scope:CoroutineScope,toFeature:()->Unit){
ComponentDashboard(onNavigate = { /*TODO*/ })
}

@Composable
fun ComponentDashboard(onNavigate:()->Unit,modifier: Modifier=Modifier){
    Scaffold(topBar = {MainAppBar()},bottomBar ={ BottomFloatingAction()},backgroundColor = BackgroundCOlor ) {
        Column( modifier=modifier.padding(start = 16.dp,end = 16.dp),) {
            Text("Upcoming Alarm",style = TextStyle(fontSize = 18.sp,color = TextColor))
            LazyColumn(
                content ={
                    items(count = 3,itemContent = {
                            index ->
                        Spacer(modifier = modifier.height(10.dp))
                        ItemAlarm()
                    })
                })
        }

    }
}

@Preview
@Composable
fun PreviewComponentDashboard(){
    ComponentDashboard(onNavigate = { /*TODO*/ })
}