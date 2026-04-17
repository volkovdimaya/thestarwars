package com.dima.thestarwars.domain.home.api

import com.dima.thestarwars.data.common.ApiResult
import com.dima.thestarwars.data.home.network.dto.ResponseDto
import kotlinx.coroutines.flow.Flow

interface HomeRepositoryNetwork {
    fun getCharactersShortList(numberPage: Int): Flow<ApiResult<ResponseDto>>
}