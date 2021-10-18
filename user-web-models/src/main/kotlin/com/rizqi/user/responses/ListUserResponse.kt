package com.rizqi.user.responses

import com.rizqi.user.models.User

data class ListUserResponse(val data: List<User>) : CommonResponse()
