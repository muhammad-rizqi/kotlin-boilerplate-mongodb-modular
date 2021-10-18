package com.rizqi.user.requests

data class UserRequest(
    val id: String,
    val username: String,
    val email: String,
    val fullName: String,
    val bio: String,
    val location: String
)
