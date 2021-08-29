package com.trian.module.ui.components

import android.widget.TimePicker
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.viewinterop.AndroidView
import com.trian.module.R

@Composable

fun MyTimePicker(onDatePicker:(hour:Int,minute:Int)->Unit,modifier: Modifier = Modifier) {
    AndroidView({
        TimePicker(android.view.ContextThemeWrapper(it, R.style.CustomCalendar))
    },
    Modifier.wrapContentSize().background(Color.Gray),
        update = {
            view->
            view.setOnTimeChangedListener{
                _,hour,min->
                onDatePicker(hour,min)
            }
            }
        )
}