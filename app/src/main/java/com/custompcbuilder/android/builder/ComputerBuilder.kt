package com.custompcbuilder.android.builder

import com.custompcbuilder.android.data.model.CPU
import com.custompcbuilder.android.data.model.CustomComputer
import com.custompcbuilder.android.data.model.RAM
import com.custompcbuilder.android.data.model.Storage

interface ComputerBuilder {
    fun setCPU(cpu: CPU): ComputerBuilder
    fun setRAM(ram: RAM): ComputerBuilder
    fun setStorage(storage: Storage): ComputerBuilder
    fun build(): CustomComputer
}