package com.trian.common.utils.network
/**
 * Entry point Activity of App
 * Author Trian Damai
 * Created at 03/09/2021
 * **/
sealed class NetworkStatus<T>(val data: T? = null, val errorMessage: String? = null) {
    class Success<T>(data: T?) : NetworkStatus<T>(data)
    class Error<T>(errorMessage: String?, data: T? = null) : NetworkStatus<T>(data, errorMessage)
    class Loading<T>(data: T? = null) : NetworkStatus<T>(data)
}