package com.dima.thestarwars.data.home.network.dto

import com.google.gson.annotations.SerializedName

data class ResponseDto(
    val page: Int,
    val results : List<PeopleResponseDto>
)

data class PeopleResponseDto(
    val name: String,
    val height: String,
    val mass: String,
    @SerializedName("hair_color")
    val hair: String,
    @SerializedName("eye_color")
    val eye: String,
)
