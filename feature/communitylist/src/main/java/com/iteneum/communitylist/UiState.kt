package com.iteneum.leasepert.utilities.state

interface UiState<T> : SimpleUiState {
    var data: T?
    fun isInitialized(): Boolean = this.data != null
}

interface SimpleUiState {
    var loading: Boolean
    val error: Int?
        get() = null
}

//Option 1
sealed class MyUiState<DATA> : UiState<DATA> {
    data class Loading<DATA>(override val error: Int? = null) : MyUiState<DATA>() {
        override var loading: Boolean = true
        override var data: DATA? = null
    }

    data class Success<DATA>(val result: DATA) : MyUiState<DATA>() {
        override var loading: Boolean = false
        override var data: DATA? = result
    }

    data class Error<DATA>(override val error: Int, val message: String? = null) : MyUiState<DATA>() {
        override var loading: Boolean = false
        override var data: DATA? = null
    }
}

//Option 2
sealed class SecondUiState {
    object Loading : SecondUiState()
    object Error : SecondUiState()
    data class Success(
        val value: String,
        val value2: String,
    ) : SecondUiState()
}


fun drawView(){
    //Option 1
    val uiState: MyUiState<String> = MyUiState.Success("Hello, world!")

    when(uiState){
        is MyUiState.Error -> {
            uiState.error
        }
        is MyUiState.Loading -> {
            uiState.loading
        }
        is MyUiState.Success ->{
            uiState.data
        }
    }

    //Option 2
    val uiState2: SecondUiState = SecondUiState.Success("Hello, world!","Value 2")

    when(uiState2){
        SecondUiState.Error -> {

        }
        SecondUiState.Loading -> {

        }
        is SecondUiState.Success -> {
            uiState2.value
        }
    }
}