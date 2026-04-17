package com.dima.thestarwars.data.home.network.Impl

import com.dima.thestarwars.data.common.ApiResult
import com.dima.thestarwars.data.common.SafeApiCallHelper
import com.dima.thestarwars.data.home.network.HomeApi
import com.dima.thestarwars.data.home.network.dto.ResponseDto
import com.dima.thestarwars.domain.home.api.HomeRepositoryNetwork
import kotlinx.coroutines.flow.Flow

class HomeRepositoryNetworkImpl(
    private val safeApi: SafeApiCallHelper,
    private val api: HomeApi,
) : HomeRepositoryNetwork {
    override fun getCharactersShortList(numberPage: Int): Flow<ApiResult<ResponseDto>> =
        safeApi.safeApiCall {
            api.getAllPeople()
        }

}