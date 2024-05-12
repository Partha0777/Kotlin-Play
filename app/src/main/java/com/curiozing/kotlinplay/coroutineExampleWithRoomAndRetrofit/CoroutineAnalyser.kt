package com.curiozing.kotlinplay.coroutineExampleWithRoomAndRetrofit

import android.widget.EditText
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.min


@Composable
fun CoroutineAnalyser() {

    val analyserViewModel by lazy { AnalyserViewModel() }

    Surface {
        val numberInput = remember { mutableStateOf("") }
        val numberOfCoroutine = remember { mutableStateOf("") }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = "Enter Number: ")
            TextField(
                keyboardOptions = KeyboardOptions().copy(keyboardType = KeyboardType.Decimal),
                modifier = Modifier.height(50.dp),
                value = numberInput.value, onValueChange = {
                    numberInput.value = it
                })
            Spacer(modifier = Modifier.height(24.dp))
            Text(text = "Enter Number of coroutine: ")
            TextField(
                textStyle = TextStyle(),
                keyboardOptions = KeyboardOptions().copy(keyboardType = KeyboardType.Decimal),
                modifier = Modifier.height(50.dp),
                value = numberOfCoroutine.value, onValueChange = {
                    numberOfCoroutine.value = it
                })
            Spacer(modifier = Modifier.height(20.dp))
            Text(text = "Total Time took for Calc  ${analyserViewModel.totalTimeForCalculation.value} ms")
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Total Time took for String Conv  ${analyserViewModel.totalTimeForStringConv.value} ms")
            Spacer(modifier = Modifier.height(20.dp))
            Button(onClick = {
               analyserViewModel.factorial(numberInput.value.toInt(),numberOfCoroutine.value.toInt())
            }) {
                Text(text = "Calculate")
            }
        }
    }
}