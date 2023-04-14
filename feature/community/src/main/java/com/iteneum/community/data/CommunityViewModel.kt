package com.iteneum.community.data

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.*
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import com.iteneum.community.domain.CardMenuItem
import com.iteneum.community.domain.CardModel

class CommunityViewModel : ViewModel() {
    private val _communityViewModelState = mutableStateOf(CommunityViewStates())
    val communityViewModelState: State<CommunityViewStates>
        get() = _communityViewModelState
    private val _buttonCards = mutableStateListOf<CardModel>()
    val buttonCards: SnapshotStateList<CardModel>
        get() = _buttonCards
    init {
        loadButtonCards()
    }
    fun loadButtonCards() {
        val cards = listOf(
            CardModel(Icons.Outlined.Diamond, CardMenuItem.AMENITIES),
            CardModel(Icons.Outlined.Event, CardMenuItem.EVENTS),
            CardModel(Icons.Outlined.QuestionAnswer, CardMenuItem.COMMUNITY_WALL),
            CardModel(Icons.Outlined.LibraryBooks, CardMenuItem.DOITYOURSELF),
            CardModel(Icons.Outlined.Store, CardMenuItem.SERVICES)
        )
        _buttonCards.addAll(cards)
    }
    fun onItemClick(model: CardModel) {
        println(model)
    }
}