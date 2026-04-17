package com.dima.thestarwars.data.common

import android.app.Application
import com.dima.thestarwars.until.isConnectedInternet
import kotlin.coroutines.cancellation.CancellationException

class SafeApiCallHelper(private val application: Application) {

    fun <T> safeApiCall(
        apiCall: suspend () -> T
    ): kotlinx.coroutines.flow.Flow<ApiResult<T>> = kotlinx.coroutines.flow.flow {
        if (!isConnectedInternet(application)) {
            emit(ApiResult.Error(ErrorType.NO_INTERNET, "Нет соединения с интернетом"))
            return@flow
        }

        try {
            val response = apiCall()
            emit(ApiResult.Success(response))
        } catch (e: Exception) {

            if (e is CancellationException) throw e

            when (e) {
                is java.net.SocketTimeoutException -> {
                    android.util.Log.e("SafeApiCallNoAuth", "Timeout: ", e)
                    emit(ApiResult.Error(ErrorType.ERROR, "Сервер не отвечает"))
                }
                is retrofit2.HttpException -> {
                    when (e.code()) {
                        404 -> emit(ApiResult.Error(ErrorType.NOT_FOUND, "Не найдено"))
                        else -> emit(ApiResult.Error(ErrorType.ERROR, "Ошибка сервера: ${e.code()}"))
                    }
                }
                else -> {
                    emit(ApiResult.Error(ErrorType.ERROR, e.localizedMessage ?: "Неизвестная ошибка"))
                }
            }
        }
    }


}