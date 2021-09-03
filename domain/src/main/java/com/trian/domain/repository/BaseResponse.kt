package com.trian.domain.repository

/**
 * Entry point Activity of App
 * Author Trian Damai
 * Created at 03/09/2021
 * **/
data class BaseResponse<T>(val success:Boolean,val data:T,val message:String)
