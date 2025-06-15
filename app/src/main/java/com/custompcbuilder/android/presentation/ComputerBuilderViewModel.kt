package com.custompcbuilder.android.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.custompcbuilder.android.builder.CustomComputerBuilder
import com.custompcbuilder.android.data.model.CPU
import com.custompcbuilder.android.data.model.CustomComputer
import com.custompcbuilder.android.data.model.RAM
import com.custompcbuilder.android.data.model.Storage

class ComputerBuilderViewModel: ViewModel() {
    private val builder = CustomComputerBuilder()

    private val _customComputer = MutableLiveData<CustomComputer>()
    val customComputer : LiveData<CustomComputer> = _customComputer

    fun chooseCPU(cpu: CPU){builder.setCPU(cpu)}
    fun chooseRAM(ram: RAM){builder.setRAM(ram)}
    fun chooseStorage(storage: Storage){builder.setStorage(storage)}

    fun buildComputer(){
        try{
            _customComputer.value = builder.build()
        }catch (e: IllegalStateException){

        }
    }
}