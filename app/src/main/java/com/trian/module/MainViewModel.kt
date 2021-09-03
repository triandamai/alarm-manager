package com.trian.module

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.trian.data.repository.AlarmRepository
import com.trian.domain.entities.Alarm
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.runBlocking
import javax.inject.Inject
/**
 * `ViewModel`
 * Author Trian Damai
 * Created at 03/09/2021
 * **/
@HiltViewModel
class MainViewModel @Inject constructor(
    private val alarmRepository: AlarmRepository
) :ViewModel(){

    fun getListAlarms():LiveData<List<Alarm>> = liveData {
        emitSource(alarmRepository.getListAlarm())
    }


    fun insertAlarm(alarm:Alarm) = runBlocking{
        alarmRepository.insertAlarm(alarm)
    }
}