package com.iteneum

import androidx.compose.ui.graphics.Color
import com.iteneum.designsystem.components.getRandomColor
import kotlin.random.Random


/**
 * [UserDomain] to handle the user information
 * @author Melissa Arellano
 */
data class UserDomain(
    val username: String = "",
    val currentBalance: Double = 0.0,
    val serviceRequestInProgress: Int = 0,
    val amenityReservetion: Int = 0,
    val notification: NotificationDomain = NotificationDomain(),
    val events: List<EventDomain> = emptyList()
)

/**
 * [NotificationDomain] to handle the notification information
 * @author Melissa Arellano
 */
data class NotificationDomain(
    val notificationCount: Int = 0,
    val showBadge: Boolean = false
)

/**
 * [EventDomain] to handle the event information
 * @author Melissa Arellano
 */
data class EventDomain(
    val title: String,
    val description: String,
    val buttonText: String,
    val color: Color = getRandomColor(Random.nextInt(0, 3))
)