package com.rizqi.user.services

import com.rizqi.user.models.User

interface UserService {
  fun addData(data: User): Pair<User?, Boolean>
  fun getDataById(id: String): User
  fun getAllData(): List<User>
  fun updateData(id: String, data: User): Pair<User?, Boolean>
  fun deleteData(id: String): Boolean

}
