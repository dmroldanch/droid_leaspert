package com.iteneum.network

/**
 * This class is for the states network responses, it can has modification with the structure.
 * @author Carlos Hernandez
 */
sealed class DataState<out T> {

    data class Success<out T>(val data: T) : DataState<T>()

    data class Error(val exception: Int, val errorCode: Int = 0) : DataState<Nothing>()

    data class Loading(val isLoading: Boolean) : DataState<Nothing>()
}