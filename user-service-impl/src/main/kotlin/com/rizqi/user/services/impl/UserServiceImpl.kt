package com.rizqi.user.services.impl

import com.rizqi.user.models.User
import com.rizqi.user.repository.UserRepository
import com.rizqi.user.services.UserService
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserServiceImpl(@Autowired val repository: UserRepository) : UserService {

    private val logger = LoggerFactory.getLogger(this.javaClass)

    override fun getDataById(id: String): User {
        return repository.findById(id).get()
    }

    override fun getAllData(): List<User> {
        return repository.findAll()
    }


    override fun addData(data: User): Pair<User?, Boolean> {
        return try {
            repository.save(data)
            Pair(data, true)
        } catch (ex: Exception) {
            logger.error(ex.message)
            Pair(null, false)
        }
    }

    override fun deleteData(id: String): Boolean {
        return try {
            repository.deleteById(id)
            true
        } catch (ex: Exception) {
            logger.error(ex.message)
            false
        }
    }

    override fun updateData(id: String, data: User): Pair<User?, Boolean> {
        return try {
            val temp = repository.findById(id)

            temp.get().let {
                repository.save(
                    User(
                        temp.get().id,
                        data.username,
                        data.email,
                        data.fullName,
                        data.bio,
                        data.location
                    )
                )
            }
            Pair(data, true)
        } catch (ex: Exception) {
            Pair(data, false)
        }
    }
}
