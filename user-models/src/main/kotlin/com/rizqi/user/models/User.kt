package com.rizqi.user.models

import org.springframework.data.mongodb.core.mapping.Document
import javax.persistence.Id

@Document(collection="user")
data class User(
    @Id val id: String = "",
    val username: String = "",
    val email: String = "",
    val fullName: String = "",
    val bio: String = "",
    val location: String = "")
