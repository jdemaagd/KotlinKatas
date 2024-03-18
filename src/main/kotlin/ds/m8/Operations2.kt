package ds.m8

import java.util.*
import kotlin.math.roundToInt
import kotlin.math.sqrt

fun main() {
    // NOTE: MutableList
    val list1 = mutableListOf(1, 2, 5)
    println("-----Created With Items-----")
    for (i in list1) {
        println("list item $i")
    }
    // Adding Items
    list1.add(6)     //(1)
    list1.add(2, 3)  //(2)
    list1.add(3, 4)  //(3)
    println("-----After Adding Items-----")
    for (i in list1) {
        println("list item $i")
    }
    println()

    // NOTE: drop operation
    val list2 = 1.until(50).toList()
    println("list.drop(20) -> ${list2.drop(20)}")
    println("list.dropLast(20) -> ${list2.dropLast(20)}")
    println()

    // NOTE: filter operation
    val list3 = 1.until(50).toList()
    println("Filtered List with Even Numbers-> ${list3.filter { it % 2 == 0 }}")
    val filteredList = list3.filter {
        val sqRoot = sqrt(it.toDouble()).roundToInt()
        sqRoot * sqRoot == it
    }
    println("Filtered List with Perfect Squares -> $filteredList")
    println()

    // NOTE: flatMap operation
    val list4 = listOf(10, 20, 30)
    println("flatMappedList -> ${
        list4.flatMap {
            it.rangeTo(it * 2).toList()
        }
    }")
    println()

    // NOTE: map operation
    val list5 = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    println("modifiedList -> ${list5.map { it + 3 }}")
    println()

    // NOTE: take operation
    val list6 = IntArray(100) { it -> it * 10 }
    println("list.take(10) -> ${list6.take(10)}")                                            //(1)
    println("list.takeLast(10) -> ${list6.takeLast(10)}")                                    //(2)
    println("list.takeWhile { it <= 50 } -> ${list6.takeWhile { it <= 50 }}")                //(3)
    println("list.takeLastWhile { it >= 900 } -> ${list6.takeLastWhile { it >= 900 }}")      //(4)
    println()

    // NOTE: zip operation
    val names = listOf("Chandra", "Rivu", "Nick", "Ahmed")
    val ages = listOf(30, 27, 35, 19)
    println(names.zip(ages))
    println()

    // NOTE: Search
    val list7 = listOf(10, 8, 18, 45, 63, 49, 88, 15, 62)
    println("Index of 18 is ${list7.binarySearch(18)}")
    println()

    // NOTE: Set
    val set = mutableSetOf(1, 2, 3, 4, 4, 1, 2)
    println("set before add $set")
    set.add(4)
    set.add(5)
    set.add(5)
    set.add(6)
    println("set after add $set")
    println()

    // NOTE: Sort
    val list8 = listOf(10, 8, 18, 45, 63, 49, 88, 15, 62)
    val linkedList = LinkedList(list8)
    linkedList.sort()
    for (i in linkedList) {
        println("List Item $i")
    }
    println()

    // NOTE: Sorted
    val list9 = listOf(10, 8, 18, 45, 63, 49, 88, 15, 62)
    val sortedList = list9.sorted()
    for (i in sortedList) {
        println("List Item $i")
    }
}