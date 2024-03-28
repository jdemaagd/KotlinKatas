package com.kryptopass.kotlinkatas.data_structures.m8

import java.util.*

data class MyDataClass(
    val someNumericValue: Int,
    val someStringValue: String
)

data class Employee(
    val employeeID: Int,
    val employeeName: String
)

fun main() {
    // NOTE: Custom Object Set
    val dataClassSet = setOf(
        MyDataClass(1, "1st obj"),
        MyDataClass(2, "2nd obj"),
        MyDataClass(3, "3rd obj"),
        MyDataClass(2, "2nd obj"),
        MyDataClass(4, "4th obj"),
        MyDataClass(5, "5th obj"),
        MyDataClass(2, "will be added"),
        MyDataClass(3, "3rd obj")
    )
    println("Printing items of dataClassSet one by one")
    for (item in dataClassSet) {
        println(item)
    }
    println()

    // NOTE: Custom Sort
    val employeeList = listOf(
        Employee(2, "Chandra Sekhar Nayak"),
        Employee(1, "Rivu Chakraborty"),
        Employee(4, "Indranil Dutta"),
        Employee(3, "Sonkho Deep Mondal"),
        Employee(6, "Debraj Dey"),
        Employee(5, "Koushik Mridha")
    )
    // NOTE: return a negative value if first one is less than second one,
    // 0, if both of them should be equal,
    // and a positive value if first one is greater than second one
    val sortedEmpList = employeeList.sortedWith { e1, e2 ->
        when {
            e1?.employeeID ?: 0 <= e2?.employeeID ?: 0 -> -1
            e1?.employeeID ?: 0 == e2?.employeeID ?: 0 -> 0
            else -> 1
        }
    }
    for (employee in sortedEmpList) {
        println(employee)
    }
    println()

    // NOTE: Functional Sort
    employeeList.sortedBy {
        it.employeeID
    }.forEach {
        println(it)
    }
    println()

    // NOTE: LinkedList
    val list1 = listOf(10, 8, 18, 45, 63, 49, 88, 15, 62)
    val linkedList = LinkedList(list1)
    for (i in linkedList) {
        println("List Item: $i")
    }
    println()

    // NOTE: Maps
    val map = mapOf(
        "Key One" to 1.0f,
        "Key Two" to 2.0f,
        "Key Three" to 3.0f,
        "Key Four" to 4.0f,
        "Key Five" to 5.0f,
        "Key Six" to 0.0f, //(1)
        "Key Six" to 6.0f  //(2)
    )
    println("The value at Key `Key Four` is ${map["Key Four"]}")
    println("Contents in map")
    for (entry in map) {
        println("Key ${entry.key}, Value ${entry.value}")
    }
    val mutableMap = map.toMutableMap()
    println("Replacing value at key - `Key Five` - ${mutableMap.put("Key Five", 5.5f)}")//(3)
    println("Contents in mutableMap")
    for (entry in mutableMap) {
        println("Key ${entry.key}, Value ${entry.value}")
    }

    // NOTE: Mutable Access
    val list2 = mutableListOf(1, 2, 3, 0, 5, 6, 7, 8)
    list2[3] = 4
    println("3rd and 4th Item on List -> ${list2[3]}, ${list2.get(4)}")
    println()
}