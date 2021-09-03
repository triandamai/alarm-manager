package com.trian.module.ui.components

import android.view.ContextThemeWrapper
import android.widget.NumberPicker
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import com.trian.module.R

/**
 * Entry point Activity of App
 * Author Trian Damai
 * Created at 03/09/2021
 * **/
@Composable
fun MyNumberPicker(min:Int,max:Int,onValueChange:(old:Int,new:Int)->Unit) {
    AndroidView({
        NumberPicker(
            ContextThemeWrapper(it, R.style.CustomCalendar),

        )
    },update = {

        view->
        view.minValue = min
        view.maxValue = max
        view.setOnValueChangedListener { 
                _, oldval, newval ->
            onValueChange(oldval,newval) }
    })
}

@Preview
@Composable
fun PreviewMyNumberPicker(){
    MyNumberPicker(10,20,onValueChange = {old: Int, new: Int ->  })
}

