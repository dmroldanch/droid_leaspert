package com.iteneum.communitywall.domain

/**
[Post] is a data class that represents a post in a community or feed in an Android application. It contains four properties:

[img]: A string representing the URL or path of the image associated with the post.
[name]: A string representing the name of the author of the post.
[time]: A string representing the time of the post, e.g. "10m" for 10 minutes ago.
[message]: A string representing the content of the message in the post.
This data class is used to store and manipulate information about a post in the context of the application, such as displaying post details in the UI, storing and retrieving post data in a database, or communicating with a web service for posting or retrieving posts.

@property img The URL or path of the image associated with the post.
@property name The name of the author of the post.
@property time The time of the post.
@property message The content of the message in the post.
@author Irving Ulises Gonzalez Uscanga
 **/

data class Post(
    val img : String,
    val name : String,
    val time : String,
    val message : String
)