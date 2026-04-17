package com.dima.thestarwars.data.home.network

import com.dima.thestarwars.data.home.network.dto.ResponseDto
import retrofit2.http.GET
import retrofit2.http.Path

interface HomeApi {
    @GET("people/")
    suspend fun getAllPeople() : ResponseDto

    @GET("planets/{planetId}")
    suspend fun getPlanet(@Path("planetId") planetId: String): ResponseDto
}