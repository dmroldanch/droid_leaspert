package com.iteneum.designsystem.components.snackbar

import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class SnackBarDemoAppState(
    val snackBarState: SnackbarHostState,
    val snackBarScope: CoroutineScope
) {
    fun showSnackBar(message: String, duration: SnackbarDuration = SnackbarDuration.Short) {
        snackBarScope.launch {
            snackBarState.showSnackbar(
                message = message,
                duration = duration
            )
        }
    }
}

@Composable
fun rememberSnackBarDemoAppState(
    snackBarState: SnackbarHostState = remember {
        SnackbarHostState()
    },
    snackBarScope: CoroutineScope = rememberCoroutineScope()
) = remember(snackBarState, snackBarScope) {
    SnackBarDemoAppState(
        snackBarState = snackBarState,
        snackBarScope = snackBarScope
    )
}