package com.iteneum.designsystem.utils

import android.content.ContentResolver
import android.net.Uri
import android.provider.OpenableColumns

/**
 * This is a extension function of the URI to get the file name.
 *
 * @param contentResolver is the content resolver.
 * @return fileName return a string with the file name.
 *
 * @author Melissa Arellano
 */
internal fun Uri.getFileName(contentResolver: ContentResolver): String {
    var fileName: String = ""
    this.let { uri ->
        contentResolver.query(uri, null, null, null, null)
    }?.use { cursor ->
        val nameIndex = cursor.getColumnIndex(OpenableColumns.DISPLAY_NAME)
        cursor.moveToFirst()
        fileName = cursor.getString(nameIndex)
    }
    return fileName
}