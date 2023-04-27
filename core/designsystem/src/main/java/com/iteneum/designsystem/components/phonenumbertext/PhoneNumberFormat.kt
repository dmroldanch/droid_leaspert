package com.iteneum.designsystem.components.phonenumbertext

import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation
import androidx.core.text.isDigitsOnly

/**
 * Class that enables to have number phone in USA format.
 * Inserts a separator depending on the number position.
 *
 * @author Yaritza Moreno
 * @modifiedBy Jose Miguel Garcia Reyes
* */

class PhoneNumberTransformation : VisualTransformation {
    private val separator = " - "
    override fun filter(text: AnnotatedString): TransformedText {
        val separatorPositionA = 2
        val separatorPositionB = 5
        val phoneNumberRange = 0 .. 10
        val output = buildString {
            for ((index, char) in text.withIndex()) {
                if (text.text.length <= 10 && text.text.isDigitsOnly())
                    append(char)
                if (index == separatorPositionA || index == separatorPositionB)
                    append(separator)
            }
        }
        val outputOffsets = calculateOutputOffsets(output)
        val separatorIndices = calculateSeparatorOffsets(output)

        val offsetTranslator = object : OffsetMapping {
            override fun originalToTransformed(offset: Int): Int {
                return if (offset in phoneNumberRange)
                    outputOffsets[offset]
                else
                    outputOffsets[10]
            }
            override fun transformedToOriginal(offset: Int): Int {
                val separatorCharactersBeforeOffset = separatorIndices.count { it < offset }
                return offset - separatorCharactersBeforeOffset
            }
        }
        return TransformedText(AnnotatedString(output), offsetTranslator)
    }
}

private fun calculateOutputOffsets(output: String): List<Int> {
    val digitOffsets = output.mapIndexedNotNull { index, char ->
        index.takeIf { char.isDigit() }?.plus(1)
    }
    return listOf(0) + digitOffsets.dropLast(1) + output.length
}

private fun calculateSeparatorOffsets(output: String): List<Int> {
    return output.mapIndexedNotNull { index, c ->
        index.takeUnless { c.isDigit() }
    }
}
