package com.rizqi.user.repository

import com.rizqi.user.models.User
import org.springframework.data.mongodb.repository.MongoRepository

interface UserRepository : MongoRepository<User, String>
