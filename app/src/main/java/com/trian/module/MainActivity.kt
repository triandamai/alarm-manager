package com.trian.module


import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.pager.ExperimentalPagerApi

import com.trian.common.utils.route.Routes
import com.trian.domain.entities.Alarm
import com.trian.module.services.Persistence
import com.trian.module.ui.pages.*
import com.trian.module.ui.theme.TesMultiModuleTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

/**
 * Entry point Activity of App
 * Author Trian Damai
 * Created at 03/09/2021
 * **/

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel: MainViewModel  by viewModels()

    @Inject
    lateinit var persistence: Persistence

    private val ALARM_REQUEST_CODE = 134
    @ExperimentalPagerApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TesMultiModuleTheme {
                val navHostController = rememberNavController()
                val coroutineScope = rememberCoroutineScope()
                NavHost(navController =navHostController,startDestination = Routes.DASHBOARD.name){
                    composable(Routes.SPLASH.name){
                        PageSplashScreen(navHostController,coroutineScope){hour, minute ->
                            setTime(hours = hour,minute = minute)
                        }
                    }
                    composable(Routes.ONBOARD.name){
                        PageOnBoarding(navHostController, coroutineScope)
                    }
                    composable(Routes.DASHBOARD.name){
                        PageDashboard(
                            viewModel,
                            navHostController,
                            coroutineScope
                        )
                    }
                    composable(Routes.COMPOSE.name){
                        PageNewAlarm(navHostController, coroutineScope)
                    }
                    composable(Routes.LOGIN.name){
                        PageLogin(navHostController,coroutineScope)
                    }
                    composable(Routes.REGISTER.name){
                        PageRegister()
                    }
                }
            }
        }





    }

    fun setTime(hours:Int,minute:Int){
        Log.e("SETTIME","$hours -> $minute")
        persistence.SaveData(hours,minute)
        persistence.setAlarm()

    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview
@Composable
fun DefaultPreview() {
    TesMultiModuleTheme {
        Greeting("Android")
    }
}