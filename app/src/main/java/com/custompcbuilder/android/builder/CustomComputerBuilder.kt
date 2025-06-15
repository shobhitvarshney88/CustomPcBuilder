package com.custompcbuilder.android.builder

import com.custompcbuilder.android.data.model.CPU
import com.custompcbuilder.android.data.model.CustomComputer
import com.custompcbuilder.android.data.model.RAM
import com.custompcbuilder.android.data.model.Storage

class CustomComputerBuilder : ComputerBuilder {
    private var cpu: CPU?=null
    private var ram: RAM?=null
    private var storage: Storage?=null
    override fun setCPU(cpu: CPU): ComputerBuilder {
        this.cpu = cpu
        return this
    }

    override fun setRAM(ram: RAM): ComputerBuilder {
        this.ram = ram
        return this
    }

    override fun setStorage(storage: Storage): ComputerBuilder {
        this.storage = storage
        return this
    }

    override fun build(): CustomComputer {
        if(cpu==null || ram==null || storage == null){
            throw IllegalStateException("All components are req..")
        }
        return CustomComputer(cpu,ram,storage)
    }
}