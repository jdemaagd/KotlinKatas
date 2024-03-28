package com.kryptopass.katas.data_structures.m3

fun main(args: Array<String>) {
    val doublyLinkyList = DoublyLinkyList<String>()
    println("First item of the linky list is - ${doublyLinkyList.getFirst()}")
    println("Last item of the linky list is - ${doublyLinkyList.getLast()}")

    println()
    doublyLinkyList.add("Kotlin")
    println("First item of the linky list is - ${doublyLinkyList.getFirst()}")
    println("Last item of the linky list is - ${doublyLinkyList.getLast()}")

    println()
    doublyLinkyList.add("Java")
    println("First item of the linky list is - ${doublyLinkyList.getFirst()}")
    println("Last item of the linky list is - ${doublyLinkyList.getLast()}")

    doublyLinkyList.add("C#")
    doublyLinkyList.add("Python")
    doublyLinkyList.add("JavaScript")

    println()
    println("Elements at doublyLinkyList - $doublyLinkyList")
    doublyLinkyList.remove("JavaScript")
    println("Elements at doublyLinkyList after removing JavaScript - $doublyLinkyList")
    doublyLinkyList.remove("Kotlin")
    println("Elements at doublyLinkyList after removing Kotlin - $doublyLinkyList")
    doublyLinkyList.remove("C#")
    println("Elements at doublyLinkyList after removing C# - $doublyLinkyList")
    doublyLinkyList.remove("Java")
    println("Elements at doublyLinkyList after removing Java - $doublyLinkyList")
    doublyLinkyList.remove("Python")
    println("Elements at doublyLinkyList after removing Python - $doublyLinkyList")

    testGetFirst2()
    testAdd2()
    testGet2()
    testSet2()
    testRemoveFirst2()
    testRemoveLast2()
    testRemoveValue2()
    testAddAll2()
}

fun testGetFirst2() {
    println()
    println("==================================")
    println("getFirst method testing started")
    val doublyLinkyList = DoublyLinkyList<String>()
    println(doublyLinkyList.getFirst() == null)

    doublyLinkyList.add("Kotlin")
    println(doublyLinkyList.getFirst() == "Kotlin")

    doublyLinkyList.add("Java")
    println(doublyLinkyList.getFirst() == "Kotlin")

    doublyLinkyList.add("Python")
    println(doublyLinkyList.getFirst() == "Kotlin")

    doublyLinkyList.add(0, "Python")
    println(doublyLinkyList.getFirst() == "Python")

    doublyLinkyList.add(1, "JavaScript")
    println(doublyLinkyList.getFirst() == "Python")

    doublyLinkyList.set(0, "JavaScript")
    println(doublyLinkyList.getFirst() == "JavaScript")

    doublyLinkyList.set(1, "Kotlin")
    println(doublyLinkyList.getFirst() == "JavaScript")

    doublyLinkyList.addFirst("Kotlin")
    println(doublyLinkyList.getFirst() == "Kotlin")

    doublyLinkyList.addLast("JavaScript")
    println(doublyLinkyList.getFirst() == "Kotlin")

    println("getFirst method testing ended")
    println("==================================")
    println()
    doublyLinkyList.clear()
    println("Elements at LinkyList - $doublyLinkyList")

    doublyLinkyList.addFirst("Kotlin")
    println("Elements at LinkyList - $doublyLinkyList")

    doublyLinkyList.addFirst("Kotlin")
    println("Elements at LinkyList - $doublyLinkyList")

    doublyLinkyList.addFirst("Java")
    println("Elements at LinkyList - $doublyLinkyList")

    doublyLinkyList.addFirst("Python")
    println("Elements at LinkyList - $doublyLinkyList")
}

fun testAdd2() {
    println()
    println("==================================")
    println("testAdd method testing started")
    val doublyLinkyList = DoublyLinkyList<String>()
    doublyLinkyList.add("Kotlin")
    doublyLinkyList.add("Java")
    doublyLinkyList.add("C#")
    doublyLinkyList.add("C")
    doublyLinkyList.add("C++")
    println("Elements at LinkyList - $doublyLinkyList")

    println()
    doublyLinkyList.add(1, "JavaScript")
    println("Elements at LinkyList - $doublyLinkyList")

    println()
    doublyLinkyList.add(2, "TypeScript")
    println("Elements at LinkyList - $doublyLinkyList")

    println()
    doublyLinkyList.add(3, "CofeeScript")
    println("Elements at LinkyList - $doublyLinkyList")

    println()
    doublyLinkyList.add(7, "MongoDB")
    println("Elements at LinkyList - $doublyLinkyList")

    println()
    doublyLinkyList.add(0, "SQL")
    println("Elements at LinkyList - $doublyLinkyList")

    println("testAdd method testing started")
    println("==================================")
}

fun testGet2() {
    println()
    println("=================================")
    println("Testing get started")
    val doublyLinkyList = DoublyLinkyList<String>()
    doublyLinkyList.add("Kotlin")
    doublyLinkyList.add("Java")
    doublyLinkyList.add("C#")
    doublyLinkyList.add("C")
    doublyLinkyList.add("C++")

    println("0th Index - ${doublyLinkyList.get(0)}")
    println("1st Index - ${doublyLinkyList.get(1)}")
    println("2nd Index - ${doublyLinkyList.get(2)}")
    println("3rd Index - ${doublyLinkyList.get(3)}")
    println("4th Index - ${doublyLinkyList.get(4)}")
    println("Testing get ended")
    println("=================================")
}

fun testSet2() {
    println()
    println("=================================")
    println("Testing set started")
    val doublyLinkyList = DoublyLinkyList<String>()
    doublyLinkyList.add("Kotlin")
    doublyLinkyList.add("Java")
    doublyLinkyList.add("C#")
    doublyLinkyList.add("C")
    doublyLinkyList.add("C++")

    println("0th Index - ${doublyLinkyList.set(0, "Edited Kotlin")}")
    println("1st Index - ${doublyLinkyList.set(1, "Edited Java")}")
    println("2nd Index - ${doublyLinkyList.set(2, "Edited C#")}")
    println("3rd Index - ${doublyLinkyList.set(3, "Edited C")}")
    println("4th Index - ${doublyLinkyList.set(4, "Edited C++")}")
    println("Final list - $doublyLinkyList")
    println("Testing set ended")
    println("=================================")
}

fun testRemoveFirst2() {
    println()
    println("=================================")
    println("Testing removeFirst started")
    val doublyLinkyList = DoublyLinkyList<String>()
    doublyLinkyList.add("Kotlin")
    doublyLinkyList.add("Java")
    doublyLinkyList.add("C#")
    doublyLinkyList.add("C")
    doublyLinkyList.add("C++")

    println("List - $doublyLinkyList")
    doublyLinkyList.removeFirst()
    println("List - $doublyLinkyList")
    doublyLinkyList.removeFirst()
    println("List - $doublyLinkyList")
    doublyLinkyList.removeFirst()
    println("List - $doublyLinkyList")
    doublyLinkyList.removeFirst()
    println("List - $doublyLinkyList")
    println("Testing removeFirst ended")
    println("=================================")
}

fun testRemoveLast2() {
    println()
    println("=================================")
    println("Testing removeLast started")
    val doublyLinkyList = DoublyLinkyList<String>()
    doublyLinkyList.add("Kotlin")
    doublyLinkyList.add("Java")
    doublyLinkyList.add("C#")
    doublyLinkyList.add("C")
    doublyLinkyList.add("C++")

    println("List - $doublyLinkyList")
    doublyLinkyList.removeLast()
    println("List - $doublyLinkyList")
    doublyLinkyList.removeLast()
    println("List - $doublyLinkyList")
    doublyLinkyList.removeLast()
    println("List - $doublyLinkyList")
    doublyLinkyList.removeLast()
    println("List - $doublyLinkyList")
    doublyLinkyList.removeLast()
    println("List - $doublyLinkyList")
    println("Testing removeLast ended")
    println("=================================")
}

fun testRemoveValue2() {
    println()
    println("=================================")
    println("Testing testRemoveValue started")
    val doublyLinkyList = DoublyLinkyList<String>()
    doublyLinkyList.add("Kotlin")
    doublyLinkyList.add("Java")
    doublyLinkyList.add("C#")
    doublyLinkyList.add("C")
    doublyLinkyList.add("C++")

    println("JavaScript" in doublyLinkyList)
    println("Kotlin" in doublyLinkyList)

    println("List - $doublyLinkyList")
    doublyLinkyList.remove("Java")
    println("List - $doublyLinkyList")
    doublyLinkyList.remove("Kotlin")
    println("List - $doublyLinkyList")
    doublyLinkyList.remove("JavaScript")
    println("List - $doublyLinkyList")
    doublyLinkyList.remove("Python")
    println("List - $doublyLinkyList")
    println("Testing testRemoveValue ended")
    println("=================================")
}

fun testAddAll2() {
    println()
    println("=================================")
    println("Testing testAddAll started")

    val doublyLinkyList = DoublyLinkyList<String>()

    // Add few elements at beginning of the linkedlist
    doublyLinkyList.addAll(0, arrayOf<String>("C", "C++"))
    println("List - $doublyLinkyList")
    doublyLinkyList.addAll(0, arrayOf<String>("Java", "Kotlin"))
    println("List - $doublyLinkyList")
    // Add few elements at middle of the linkedlist
    doublyLinkyList.addAll(2, arrayOf<String>("Python", "R"))
    println("List - $doublyLinkyList")
    // Add few elements at end of the linkedlist
    doublyLinkyList.addAll(doublyLinkyList.size(), arrayOf<String>("C#", "MATLAB"))
    println("List - $doublyLinkyList")
    println("Testing testAddAll ended")
    println("=================================")
}