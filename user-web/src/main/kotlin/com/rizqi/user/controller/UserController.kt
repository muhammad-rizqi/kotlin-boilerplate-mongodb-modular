package com.rizqi.user.controller

import com.rizqi.user.models.User
import com.rizqi.user.requests.UserRequest
import com.rizqi.user.responses.ListUserResponse
import com.rizqi.user.responses.UserResponse
import com.rizqi.user.services.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

fun UserRequest.toUserModel(): User = User(
    id = id,
    username = username,
    email = email,
    fullName = fullName,
    bio = bio,
    location = location
)

@RestController
@RequestMapping("/api/v1/user")
class UserController(@Autowired val service: UserService) {

    @GetMapping("/", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getAll(): ResponseEntity<ListUserResponse> {
        return ResponseEntity(ListUserResponse(service.getAllData()), HttpStatus.OK)
    }

    @PostMapping("/")
    fun postUser(@RequestBody data: UserRequest): ResponseEntity<UserResponse?> {
        try {
            val result = service.addData(data.toUserModel())
            return if (result.second) {
                val response = UserResponse(result.first)
                response.code = "201"
                response.message = "data saved"
                ResponseEntity(response, HttpStatus.CREATED)
            } else {
                val response = UserResponse(result.first)
                response.code = "403"
                ResponseEntity(response, HttpStatus.METHOD_FAILURE)
            }
        } catch (ex: Exception) {
            val response = UserResponse(null)
            response.code = "420"
            return ResponseEntity(null, HttpStatus.METHOD_FAILURE)
        }
    }

    @GetMapping("/{id}")
    fun getById(@PathVariable id: String): ResponseEntity<UserResponse> {
        return try {
            val result = service.getDataById(id)
            val response = UserResponse(result)
            response.code = "200"
            response.message = "Found"
            ResponseEntity(response, HttpStatus.OK)
        } catch (ex: Exception) {
            val response = UserResponse(null)
            response.code = "404"
            response.message = ex.localizedMessage
            ResponseEntity(response, HttpStatus.NOT_FOUND)
        }
    }


    @PutMapping("/{id}")
    fun updateData(@PathVariable id: String, @RequestBody data: UserRequest): UserResponse {
        try {
            val result = service.updateData(id, data.toUserModel())
            return if (result.second) {
                val response = UserResponse(data.toUserModel())
                response.code = "200"
                response.message = "add updated"
                response
            } else {
                val response = UserResponse(null)
                response.code = "500"
                response.message = " found"
                response
            }
        } catch (ex: Exception) {
            val response = UserResponse(null)
            response.code = "403"
            response.message = "update data was failed"
            return response
        }
    }

    @DeleteMapping("/{id}")
    fun deleteDataById(@PathVariable id: String): UserResponse {
        try {
            val result = service.deleteData(id)

            val response = UserResponse(null)

            if (result) {
                response.code = "200"
                response.message = "data was deleted"
            } else {
                response.code = "404"
                response.message = "data not found"
            }

            return response
        } catch (ex: Exception) {
            val response = UserResponse(null)
            response.code = "500"
            response.message = "deleting data is failed"
            return response
        }
    }
}
