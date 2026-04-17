package com.dima.thestarwars.data.common

sealed class ApiResult<out T> {
    data class Success<out T>(val data: T) :ApiResult<T>()
    data class Error(val type: ErrorType, val message: String) : ApiResult<Nothing>()
}
enum class ErrorType {
    NO_INTERNET,
    NOT_FOUND,
    ERROR,
}