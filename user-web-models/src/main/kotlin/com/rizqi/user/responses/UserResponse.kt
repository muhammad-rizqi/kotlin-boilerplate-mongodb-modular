package com.rizqi.user.responses

import com.rizqi.user.models.User

data class UserResponse(val data: User?) : CommonResponse()
