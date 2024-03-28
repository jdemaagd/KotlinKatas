package com.kryptopass.kotlinkatas.data_structures.m8

data class Employee2(
    val id: Int,
    val name: String,
    val salary: Int
)

fun main() {
    val employees: List<Employee2> = getEmployeesList()
    employees.filter {
        it.salary > 800
    }
}

fun getEmployeesList(): List<Employee2> {
    return listOf(
        Employee2(1, "Chandra Sekhar Nayak", 1000),
        Employee2(2, "Rivu Chakraborty", 900),
        Employee2(3, "Indranil Dutta", 800),
    )
}