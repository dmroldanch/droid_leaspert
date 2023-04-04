package com.iteneum.designsystem.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

/**
 * This function create a group of radio buttons
 *
 * @param options Number of RadioButton displayed
 * @param selectedOption This is the actual RadioButton selected
 * @param onOptionSelected Changes the current RadioButton selected
 *
 * @sample RadioButtonExample
 * @author Jose Guadalupe Rivera
 */
@Composable
fun LpRadioGroup(
    options: List<String>,
    selectedOption: String,
    onOptionSelected: (String) -> Unit,
) {
    Row() {
        options.forEach { option ->
            Row(modifier = Modifier
                .selectable(
                    selected = false,
                    onClick = { onOptionSelected(option) }
                )
            ) {
                RadioButton(
                    selected = (option == selectedOption),
                    onClick = null,
                    colors = RadioButtonDefaults.colors(
                        selectedColor = MaterialTheme.colorScheme.onPrimary
                    )
                )
                Text(text = option, Modifier.padding(start = 10.dp))
            }
            Spacer(modifier = Modifier.size(40.dp))
        }
    }
}

// This is an example of RadioGroup implementation
@Preview
@Composable
fun RadioButtonExample() {
    val options = listOf("Yes", "No", "X", "Y")
    var selectedOption by remember { mutableStateOf(options[0]) }

    LpRadioGroup(
        options = options,
        selectedOption = selectedOption,
        onOptionSelected = { option -> selectedOption = option }
    )
}