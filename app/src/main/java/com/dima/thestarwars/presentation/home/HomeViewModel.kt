package com.dima.thestarwars.presentation.home

import com.dima.thestarwars.data.common.ApiResult
import com.dima.thestarwars.domain.home.HomeInteractorImpl
import com.dima.thestarwars.presentation.common.CommonViewModel
import com.dima.thestarwars.presentation.home.api.HomeInteractor
import com.dima.thestarwars.presentation.home.models.People
import kotlinx.coroutines.flow.first

class HomeViewModel(private val interactor: HomeInteractor) : CommonViewModel<List<People>>() {
    init {
        loadContent(
            loader = {
                when (val result = interactor.getCharactersShortList().first()) {
                    is ApiResult.Success<*> -> result.data as? List<People> ?: emptyList()
                    is ApiResult.Error -> emptyList()
                }
            }
        )
    }

}