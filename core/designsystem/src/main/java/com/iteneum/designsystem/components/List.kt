package com.iteneum.designsystem.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

/**
 * Component to create a list
 *
 * @param title: If is necessary we can add a title for the component.
 * @param hint: Text for show a hint for the component.
 * @param content: Content for the list.
 */

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LpGenericList(
    modifier: Modifier = Modifier,
    title: String = "",
    hint: String = "Select Category...",
    content: List<String>
) {
    var collapsedState = remember { true }
    var text by remember { mutableStateOf(hint) }

    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth(),
            value = text,
            label = {
                Row(Modifier.background(MaterialTheme.colorScheme.background)) {
                    Text(text = title)
                }
            },
            onValueChange = {}
        )
        Row(
            modifier = Modifier.padding(4.dp)
        ) {
            if (collapsedState) {
                Row(
                    modifier = Modifier
                        .background(MaterialTheme.colorScheme.background)
                        .fillMaxWidth()
                        .clickable { collapsedState = !collapsedState },
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = text,
                        style = MaterialTheme.typography.labelMedium
                    )
                    Icon(
                        imageVector = Icons.Default.ArrowDropDown,
                        contentDescription = null
                    )
                }
            } else {
                LazyColumn {
                    items(content){item ->
                        Row(
                            modifier = Modifier
                                .padding(2.dp)
                                .clickable {
                                    collapsedState = !collapsedState
                                    text = item
                                }
                        ) {
                            Text(text = item)
                        }
                        Divider()
                    }
                }
            }
        }
    }
}
