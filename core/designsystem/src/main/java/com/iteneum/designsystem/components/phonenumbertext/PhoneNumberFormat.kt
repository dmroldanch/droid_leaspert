package com.iteneum.designsystem.components.phonenumbertext

import android.util.Log
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation

/*This block of code give format
* for number phone in USA format
* */

class PhoneNumberTransformation : VisualTransformation {
    private val separator = " - "

    override fun filter(text: AnnotatedString): TransformedText {

        val withinMaxLength = text.length <= 10

        val output = buildString {
            for ((index, char) in text.withIndex()) {
                if (withinMaxLength) {
                    append(char)
                }
                if (index == 2 || index == 5) {
                    append(separator)
                }
            }
        }

        val outputOffsets = calculateOutputOffsets(output)
        Log.d("DEBUGGING","VAL AFTER --> outputOffsets IS $outputOffsets")
        val separatorIndices = calculateSeparatorOffsets(output)

        val offsetTranslator = object : OffsetMapping {

            override fun originalToTransformed(offset: Int): Int {
                //return try {
                return if (offset in 0 .. 10)
                    outputOffsets[offset]
                else
                    outputOffsets[10]
                //}
                /*catch (e: IndexOutOfBoundsException){
                    Log.d("ERROR","OUT OF BOUNDS --> OFFSET IS $offset")
                    outputOffsets[0]
                }*/
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
