package com.dima.thestarwars.di

import com.dima.thestarwars.data.home.network.Impl.HomeRepositoryNetworkImpl
import com.dima.thestarwars.domain.home.api.HomeRepositoryNetwork
import org.koin.dsl.module

val repositoryModule = module {
    single<HomeRepositoryNetwork> {
        HomeRepositoryNetworkImpl(get(), get())
    }
}