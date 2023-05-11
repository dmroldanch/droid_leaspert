package com.iteneum.designsystem.components

import androidx.compose.material3.SnackbarDuration

sealed class UIActions {
    data class ShowSnackBar(
        val description: String,
        val titleButton: String,
        val action: () -> Unit = {},
        val duration: SnackbarDuration =  SnackbarDuration.Short
    ) : UIActions()

    object ShowLoading : UIActions()
    object ShowAlertDialog : UIActions()
}