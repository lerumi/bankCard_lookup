package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.ui.BinEnterScreen.BinEnterScreen
import com.example.myapplication.ui.BinEnterScreen.BinEnterScreenVM
import com.example.myapplication.ui.QueryListScreen.QueryListScreen
import com.example.myapplication.ui.QueryListScreen.QueryListScreenVM
import com.example.myapplication.ui.theme.MyApplicationTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                MainScreen()
            }
        }
    }
}


@Composable
fun MainScreen(
    viewModelBin: BinEnterScreenVM = hiltViewModel(),
    viewModelQueryList: QueryListScreenVM = hiltViewModel()
) {

    var currentScreen by remember { mutableStateOf(Screen.BinEnter) }

    when (currentScreen) {
        Screen.BinEnter -> {
            BinEnterScreen(
                onNavigateToQueryList = {
                    currentScreen = Screen.QueryList
                    viewModelQueryList.loadQueryList()
                },
                viewModel = viewModelBin
            )
        }

        Screen.QueryList -> {
            QueryListScreen(
                onNavigateBack = {
                    currentScreen = Screen.BinEnter
                },
                viewModel = viewModelQueryList
            )
        }
    }
}

enum class Screen {
    BinEnter,
    QueryList

}