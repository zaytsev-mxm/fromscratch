package dev.maxiscoding.fromscratch.service

import dev.maxiscoding.fromscratch.model.User
import dev.maxiscoding.fromscratch.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(private val userRepository: UserRepository) {

    fun getAllUsers(): List<User> {
        return userRepository.findAll()
    }

    fun createUser(user: User): User {
        return userRepository.save(user)
    }

    fun getUserById(id: Long): User? {
        return userRepository.findById(id)
    }

    fun updateUser(id: Long, user: User): User? {
        val existingUser = userRepository.findById(id)
        if (existingUser != null) {
            val updatedUser = existingUser.copy(name = user.name, email = user.email)
            return userRepository.save(updatedUser)
        }
        return null
    }

    fun deleteUser(id: Long) {
        userRepository.deleteById(id)
    }
}