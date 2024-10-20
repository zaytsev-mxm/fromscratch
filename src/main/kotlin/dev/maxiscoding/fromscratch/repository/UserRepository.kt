package dev.maxiscoding.fromscratch.repository

import dev.maxiscoding.fromscratch.model.User
import org.springframework.stereotype.Repository

@Repository
class UserRepository() {

    private val users = mutableListOf<User>()

    init {
        users.add(User(1, "John", "john@doe.com"))
        users.add(User(2, "Jane", "jane@doe.com"))
    }

    fun findAll(): List<User> {
        return users
    }

    fun save(user: User): User {
        users.add(user)
        return user
    }

    fun findById(id: Long): User? {
        return users.find { it.id == id }
    }

    fun deleteById(id: Long) {
        users.removeIf { it.id == id }
    }
}