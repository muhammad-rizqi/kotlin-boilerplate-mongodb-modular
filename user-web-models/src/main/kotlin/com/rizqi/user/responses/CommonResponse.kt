package com.rizqi.user.responses

open class CommonResponse(
    var code: String = "500",
    var message: String = "default error message",
    var dateTime: String = "not updated"
)
