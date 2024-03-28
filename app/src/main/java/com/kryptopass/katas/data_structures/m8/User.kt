package com.kryptopass.katas.data_structures.m8

data class User (
    val id: Int,
    val name: String,
    val dob: String
)

fun main() {
    val users: List<User> = getUsersList()
    users.sortedBy { it.id }
    users.sortedBy { it.name }
    users.sortedBy { it.dob }
}

fun getUsersList(): List<User> {
    return listOf(
        User(1, "Chandra Sekhar Nayak", "1990-01-01"),
        User(2, "Rivu Chakraborty", "1991-01-01")
    )
}
