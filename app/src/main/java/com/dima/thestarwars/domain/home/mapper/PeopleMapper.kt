package com.dima.thestarwars.domain.home.mapper

import com.dima.thestarwars.data.home.network.dto.PeopleResponseDto
import com.dima.thestarwars.presentation.home.models.People


object PeopleMapper {
    fun fromDto(dto: PeopleResponseDto): People = People(
        name = dto.name,
        height = dto.height,
        mass = dto.mass,
        hair = dto.hair ?: dto.hair ?: "n/a",
        eye = dto.eye ?: dto.eye ?: "n/a",

    )

    fun fromDtoList(dtos: List<PeopleResponseDto>): List<People> = dtos.map { fromDto(it) }
}