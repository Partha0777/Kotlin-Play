package com.curiozing.kotlinplay

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.curiozing.kotlinplay.coroutineExampleWithRoomAndRetrofit.AndroidVersionViewModel
import com.curiozing.kotlinplay.coroutineExampleWithRoomAndRetrofit.UiState
import com.curiozing.kotlinplay.coroutineExampleWithRoomAndRetrofit.Version
import com.curiozing.kotlinplay.ui.theme.KotlinPlayTheme

class MainActivity : ComponentActivity(), Analytics by AnalyticsImpl() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)


        val data = listOf("1","2","3","4","5","6","7")
        val splitNumber = 3
        val datad = listOf(1,2,3,4,5)

        val muliply = multiListWithN(datad){
           it * 2
        }
        println("muliply $muliply")
        val chunkData = mutableListOf<List<String>>()
        var i = 0
        while (i < data.size){
            val chuck:List<String> = data.subList(i, minOf(i+splitNumber,data.size))
            chunkData.add(chuck)
            i += splitNumber
        }
        println("data... $chunkData")

        registerLifeCycleOwner(this)
        setContent {
            val navController = rememberNavController()
            AppNavigation(navController = navController)
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
fun HomeScreen(navController: NavHostController){
    var viewModel = MainViewModel()
    val androidViewModel by lazy {
        AndroidVersionViewModel()
    }
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

                androidViewModel.getUiState.let {
                    when(it.value){
                        is UiState.Loading -> {
                            Button(onClick = {
                                androidViewModel.getAndroidVersions()
                            }) {
                                Text(text = "Call Android API")
                            }
                            Spacer(modifier = Modifier.height(50.dp))
                            Text(text = "")
                            Spacer(modifier = Modifier.height(50.dp))
                            Button(onClick = {
                                viewModel.getDrinks()
                            }) {
                                Text(text = "Call API <>")
                            }
                            Spacer(modifier = Modifier.height(20.dp))
                            Button(onClick = {
                                navController.navigate("coroutine")
                            }) {
                                Text(text = "Navigate Coroutine")
                            }
                        }

                        is UiState.Success ->{
                            LazyColumn(
                                content = {
                                    items((it.value as UiState.Success).response){ item ->
                                        Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
                                            Text(text = item.name)
                                            Text(text = item.version)
                                        }
                                        Spacer(modifier = Modifier.height(12.dp))
                                    }
                                }, modifier = Modifier.padding(horizontal = 12.dp)
                            )
                        }

                        else -> {

                        }
                    }

                }




            }
        }
    }


}



@Composable
fun AppNavigation(navController:NavHostController){

    NavHost(navController = navController, startDestination = "main"){

        composable(route= "main"){
            HomeScreen(navController = navController)
        }
        composable(route = "coroutine"){
            CoroutineAnalyser()
        }

    }

}


fun <T,R> multiListWithN(list: List<T>,func: (T) -> R): List<R>{
    return list.map { e-> func(e) }
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

fun <T,R>addNumbers(list: List<T>, func: (T) -> R): List<R>{
    return  list.map { e -> func(e) }
}

