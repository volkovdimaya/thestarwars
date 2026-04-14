package com.dima.thestarwars.di

import org.koin.dsl.module

val dataModule = module {
    // Здесь вы можете зарегистрировать свои репозитории, источники данных и т.д.
    // Например:
    // single { UserRepository(get()) }
    // single { ProductRepository(get()) }
}