package br.com.watched.model.api

import br.com.watched.model.api.Status.*

/**
 * ApiResponse holder provided to the UI
 *
 * @param <T>
 */
class ApiResponse<T>
constructor(val status: Status, val data: T? = null,
            val error: Throwable? = null, val isLoading: Boolean = false) {
    companion object {

        fun <T> success(data: T): ApiResponse<T> {
            return ApiResponse(SUCCESS, data, null)
        }

        fun <T> error(error: Throwable): ApiResponse<T> {
            return ApiResponse(ERROR, null, error)
        }

        fun <T> loading(isLoading: Boolean): ApiResponse<T> {
            return ApiResponse(LOADING, null, null, isLoading)
        }

    }
}