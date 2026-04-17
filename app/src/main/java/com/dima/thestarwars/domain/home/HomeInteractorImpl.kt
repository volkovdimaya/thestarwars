package com.dima.thestarwars.domain.home

import com.dima.thestarwars.data.common.ApiResult
import com.dima.thestarwars.domain.home.api.HomeRepositoryNetwork
import com.dima.thestarwars.domain.home.mapper.PeopleMapper
import com.dima.thestarwars.presentation.home.api.HomeInteractor
import com.dima.thestarwars.presentation.home.models.People
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class HomeInteractorImpl(
    private val homeRepositoryNetwork: HomeRepositoryNetwork,
) : HomeInteractor {
    override suspend fun getCharactersShortList(): Flow<ApiResult<List<People>>>  {
        return homeRepositoryNetwork.getCharactersShortList(numberPage = 1).map { result ->
            when (result) {
                is ApiResult.Success -> ApiResult.Success(PeopleMapper.fromDtoList(result.data.results))
                is ApiResult.Error -> ApiResult.Error(result.type, result.message)
            }
        }

    }
}