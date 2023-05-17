package com.iteneum.community.presentation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Diamond
import androidx.compose.material.icons.outlined.Event
import androidx.compose.material.icons.outlined.Forum
import androidx.compose.material.icons.outlined.LibraryBooks
import androidx.compose.material.icons.outlined.Store
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.iteneum.community.R
import com.iteneum.community.domain.Community
import com.iteneum.community.domain.CommunityCardType
import com.iteneum.network.DataState
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CommunityViewModel : ViewModel() {
    private val _state: MutableStateFlow<State> =
        MutableStateFlow(State.Loading)
    val state: StateFlow<State> = _state

    private val _communitySections: MutableList<Community> = mutableListOf()
    val communitySections: MutableList<Community>
        get() = _communitySections

    val cardDescriptions = mapOf(
        CommunityCardType.Amenities to R.string.cardButton_ammenities,
        CommunityCardType.Events to R.string.cardButton_events,
        CommunityCardType.CommunityWall to R.string.cardButton_communityWall,
        CommunityCardType.DoItYourself to R.string.cardButton_doItYourself,
        CommunityCardType.Services to R.string.cardButton_services,
    )

    init {
        getCommunitySections()
    }

    private fun getCommunitySections() = viewModelScope.launch {
        when (response) {
            is DataState.Success -> {
                delay(2000)
                _state.emit(State.Success)
                _communitySections.clear()
                _communitySections.addAll(response.data)
            }

            is DataState.Error -> {
                _state.emit(State.Error)
            }

            is DataState.Loading -> {
                _state.emit(State.Loading)
            }
        }
    }
}

sealed class State {
    object Loading : State()
    object Error : State()
    object Success : State()
}

val response: DataState<List<Community>> = DataState.Success(
    listOf(
        Community(
            icon = Icons.Outlined.Diamond,
            cardType = CommunityCardType.Amenities
        ),
        Community(
            icon = Icons.Outlined.Event,
            cardType = CommunityCardType.Events
        ),
        Community(
            icon = Icons.Outlined.Forum,
            cardType = CommunityCardType.CommunityWall
        ),
        Community(
            icon = Icons.Outlined.LibraryBooks,
            cardType = CommunityCardType.DoItYourself
        ),
        Community(
            icon = Icons.Outlined.Store,
            cardType = CommunityCardType.Services
        )
    )
)
