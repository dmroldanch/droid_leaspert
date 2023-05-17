package com.iteneum
/**
 * This class is for the data for each item in the list.
 * @param id the identifier id
 * @param urlImage the image url from server
 * @param title the card title
 * @param description the card description
 * @author Carlos Hernandez
 */
//TODO IT NEEDS TO BE PARCELIZE
data class Amenity(
    var id: Int = 0,
    var urlImage: String? = null,
    var title: String? = null,
    var description: String? = null
) // TODO IT NEEDS TO BE PARCELABLE