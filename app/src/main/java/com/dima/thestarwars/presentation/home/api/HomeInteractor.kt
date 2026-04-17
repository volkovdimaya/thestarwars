package com.dima.thestarwars.presentation.home.api

import com.dima.thestarwars.data.common.ApiResult
import com.dima.thestarwars.presentation.home.models.People
import kotlinx.coroutines.flow.Flow

interface HomeInteractor {
    suspend fun getCharactersShortList(): Flow<ApiResult<List<People>>>
}