package com.dima.thestarwars.di

import com.dima.thestarwars.data.common.SafeApiCallHelper
import com.dima.thestarwars.data.home.network.HomeApi
import com.dima.thestarwars.until.AppConstants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidApplication
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val dataModule = module {
    single { SafeApiCallHelper(androidApplication()) }


    single {
        val logging = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

        OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()
    }

//    single(named("retrofit")) {
    single(named("retrofit")) {
        Retrofit.Builder()
            .baseUrl(AppConstants.BASE_URL)
            .client(get())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    single<HomeApi> { get<Retrofit>(named("retrofit")).create(HomeApi::class.java) }

}