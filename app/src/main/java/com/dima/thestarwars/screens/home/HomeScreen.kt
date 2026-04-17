package com.dima.thestarwars.screens.home

import androidx.compose.runtime.Composable
import com.dima.thestarwars.presentation.home.HomeViewModel
import org.koin.androidx.compose.koinViewModel


@Composable
fun HomeScreen(viewModel: HomeViewModel = koinViewModel()) {

    viewModel.setLoading()

}