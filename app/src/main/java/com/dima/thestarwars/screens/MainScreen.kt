package com.dima.thestarwars.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import androidx.navigation.compose.rememberNavController
import com.dima.thestarwars.RootNavGraph

@Composable
fun MainScreen(){
    val navController = rememberNavController()

    Scaffold(
        topBar = {
            ToolBar(navController)
        }
    ){paddingValues ->
        val padding by rememberUpdatedState(paddingValues)
        Box(modifier = androidx.compose.ui.Modifier.padding(padding)){
            RootNavGraph(navController)

        }
    }
}