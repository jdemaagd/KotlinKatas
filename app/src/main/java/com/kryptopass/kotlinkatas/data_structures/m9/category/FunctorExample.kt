package com.kryptopass.kotlinkatas.data_structures.m9.category

fun List<Int>.convertToStr(): List<String> =
    if (size > 0) {
        val newList = ArrayList<String>(size)
        for (item in this) {
            newList.add("Modified $item")
        }
        newList
    } else {
        emptyList()
    }


fun main() {
    val intList = listOf(1, 2, 3, 4, 5)
    println(intList.convertToStr())
}
