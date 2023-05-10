package com.iteneum.communitywall.presentation

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.iteneum.communitywall.domain.Post
import com.iteneum.network.DataState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

@HiltViewModel
class CommunityWallViewModel : ViewModel() {

    //TODO STATE IS GOING TO BE USED WHEN WE NEED TO DO A BIG CHANGE IN THE VIEW
    private val _state: MutableStateFlow<CommunityWallState> =
        MutableStateFlow(CommunityWallState.Loading)
    val state: StateFlow<CommunityWallState> = _state

    //TODO MY MUTABLE DATA HAS THE POST OBJECTS LIST
    var myData: MutableList<Post> = mutableStateListOf()
        private set

    internal fun likePost() {
        //TODO WE ARE GOING TO HAVE HERE THE SERVICE CALL
    }

    internal fun getInformation() = viewModelScope.launch {
        when (response) {
            is DataState.Success -> {
                myData.clear()
                myData.addAll(response.data)
            }
            is DataState.Error -> {
                _state.emit(CommunityWallState.Error)
            }
            is DataState.Loading -> {
                _state.emit(CommunityWallState.Loading)
            }
            else -> Unit
        }
    }
}


/* OBJECTS FOR STATEFLOW  */
sealed class CommunityWallState {
    object Loading : CommunityWallState()
    object Error : CommunityWallState()
    object Success : CommunityWallState()
}

/* RESPONSE EXAMPLE */
val response: DataState<List<Post>> = DataState.Success(
    listOf(
        Post(
            "https://img.favpng.com/25/7/23/computer-icons-user-profile-avatar-image-png-favpng-LFqDyLRhe3PBXM0sx2LufsGFU.jpg",
            "Martin Perroni",
            "10m",
            "This is a post about something"
        ),
        Post(
            "https://img.favpng.com/25/7/23/computer-icons-user-profile-avatar-image-png-favpng-LFqDyLRhe3PBXM0sx2LufsGFU.jpg",
            "Martin Perroni",
            "10m",
            "This is a post about something"
        ),
        Post(
            "https://img.favpng.com/25/7/23/computer-icons-user-profile-avatar-image-png-favpng-LFqDyLRhe3PBXM0sx2LufsGFU.jpg",
            "Martin Perroni",
            "10m",
            "This is a post about something"
        ),
        Post(
            "https://img.favpng.com/25/7/23/computer-icons-user-profile-avatar-image-png-favpng-LFqDyLRhe3PBXM0sx2LufsGFU.jpg",
            "Martin Perroni",
            "10m",
            "This is a post about something"
        )
    )
)
