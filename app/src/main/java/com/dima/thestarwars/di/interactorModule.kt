package com.dima.thestarwars.di

import com.dima.thestarwars.domain.home.HomeInteractorImpl
import com.dima.thestarwars.presentation.home.api.HomeInteractor
import org.koin.dsl.module

val interactorModule = module {
    single<HomeInteractor> { HomeInteractorImpl(get()) }

}