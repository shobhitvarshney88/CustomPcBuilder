package com.custompcbuilder.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.custompcbuilder.android.data.model.CPU
import com.custompcbuilder.android.data.model.RAM
import com.custompcbuilder.android.data.model.Storage
import com.custompcbuilder.android.data.model.StorageType
import com.custompcbuilder.android.presentation.ComputerBuilderViewModel
import com.custompcbuilder.android.ui.theme.CustomPCBuilderTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            CustomPCBuilderTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ComputerBuilderScreen(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun ComputerBuilderScreen(name: String, modifier: Modifier = Modifier,viewModel: ComputerBuilderViewModel = viewModel()) {
    val computer = viewModel.customComputer.observeAsState().value
    Column(modifier = Modifier.wrapContentWidth()) {
        Button(onClick = {viewModel.chooseCPU(CPU("Intel",12,3.8))}) {
            Text(text = "Select CPU")
        }
        Button(onClick = {viewModel.chooseRAM(RAM(16,3200))}) {
            Text(text = "Select RAM")
        }
        Button(onClick = {viewModel.chooseStorage(Storage(StorageType.SSD,512))}) {
            Text(text = "Select Storage")
        }
        Button(onClick = {viewModel.buildComputer()}) {
            Text(text = "Build Computer")
        }

        computer.let {
            print("CPU: ${it?.cpu}, RAM: ${it?.ram}, Storage: ${it?.storage}")
        }

    }
}

@Preview(showBackground = true)
@Composable
fun ComputerBuilderScreenPreview() {
    CustomPCBuilderTheme {
        ComputerBuilderScreen("Android")
    }
}