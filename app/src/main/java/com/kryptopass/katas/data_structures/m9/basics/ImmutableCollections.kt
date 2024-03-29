package com.kryptopass.katas.data_structures.m9.basics

fun main() {
    // NOTE: immutable!
    val employeeList = listOf(
        Employee(2, "Chandra Sekhar Nayak"),
        Employee(1, "Rivu Chakraborty"),
        Employee(4, "Indranil Dutta"),
        Employee(3, "Sonkho Deep Mondal"),
        Employee(6, "Debraj Dey"),
        Employee(5, "Koushik Mridha")
    )

    // NOTE: sortedBy returns a new list, and doesn't modify the original list
    employeeList.sortedBy {
        it.employeeID
    }.forEach {
        println(it)
    }
}

data class Employee(val employeeID: Int, val employeeName: String)
