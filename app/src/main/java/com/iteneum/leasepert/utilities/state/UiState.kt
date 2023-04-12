package com.iteneum.leasepert.utilities.state

interface UiState<DATA> : SimpleUiState {
    var data: DATA?
    fun isInitialized(): Boolean = this.data != null
}

interface SimpleUiState {
    var loading: Boolean
    val error: Int?
        get() = null
}