package com.curiozing.kotlinplay

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import com.curiozing.kotlinplay.coroutineExampleWithRoomAndRetrofit.AndroidVersionViewModel
import com.curiozing.kotlinplay.ui.theme.KotlinPlayTheme

class MainActivity : ComponentActivity(), Analytics by AnalyticsImpl() {

    override fun onCreate(savedInstanceState: Bundle?) {
        var viewModel = MainViewModel()
        val androidViewModel by lazy {
            AndroidVersionViewModel()
        }
        super.onCreate(savedInstanceState)
        registerLifeCycleOwner(this)
        setContent {
            KotlinPlayTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        Button(onClick = {
                            androidViewModel.getAndroidVersions()
                        }) {
                            Text(text = "Call Android API")
                        }
                        Spacer(modifier = Modifier.height(50.dp))
                        Button(onClick = {
                            viewModel.getDrinks()
                        }) {
                            Text(text = "Call API <>")
                        }

                    }
                }
            }
        }
    }
}

interface Analytics {
    fun registerLifeCycleOwner(owner: LifecycleOwner) {}
}


class AnalyticsImpl : Analytics, LifecycleEventObserver {
    override fun registerLifeCycleOwner(owner: LifecycleOwner) {

        owner.lifecycle.addObserver(this)
    }

    override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {

        when (event) {
            Lifecycle.Event.ON_RESUME -> {}
            Lifecycle.Event.ON_PAUSE -> {}
            else -> Unit
        }
    }


}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    KotlinPlayTheme {
        Greeting("Android")
    }
}