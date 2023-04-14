package com.iteneum

/**
 * Data class for list items, if you are going to use list use this class for items
 * Add new params if you need it, consider initialize the param if it's not always necessary
 *
 * @param urlImage the image url from server .
 * @param title the title for a card.
 * @param description the description for a card.
 *
 * @author Carlos Hernandez
 */
data class ItemList(
    var urlImage: String? = null,
    var title: String? = null,
    var description: String? = null
)