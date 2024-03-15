package ds.m3

fun main(args: Array<String>) {
    val list = CircularLinkyList<String>()
    println("First item of the linky list is - ${list.getFirst()}")
    println("Last item of the linky list is - ${list.getLast()}")

    println()
    list.add("Kotlin")
    println("First item of the linky list is - ${list.getFirst()}")
    println("Last item of the linky list is - ${list.getLast()}")

    println()
    list.add("Java")
    println("First item of the linky list is - ${list.getFirst()}")
    println("Last item of the linky list is - ${list.getLast()}")

    list.add("C#")
    list.add("Python")
    list.add("JavaScript")

    println()
    println("Elements at list - $list")
    list.remove("JavaScript")
    println("Elements at list after removing JavaScript - $list")
    list.remove("Kotlin")
    println("Elements at list after removing Kotlin - $list")
    list.remove("C#")
    println("Elements at list after removing C# - $list")
    list.remove("Java")
    println("Elements at list after removing Java - $list")
    list.remove("Python")
    println("Elements at list after removing Python - $list")

    testGetFirst3()
    testAdd3()
    testGet3()
    testSet3()
    testRemoveFirst3()
    testRemoveLast3()
    testRemoveValue3()
}

fun testGetFirst3() {
    println()
    println("==================================")
    println("getFirst method testing started")
    val list = CircularLinkyList<String>()
    println(list.getFirst() == null)

    list.add("Kotlin")
    println(list.getFirst() == "Kotlin")

    list.add("Java")
    println(list.getFirst() == "Kotlin")

    list.add("Python")
    println(list.getFirst() == "Kotlin")

    list.add(0, "Python")
    println(list.getFirst() == "Python")

    list.add(1, "JavaScript")
    println(list.getFirst() == "Python")

    list.set(0, "JavaScript")
    println(list.getFirst() == "JavaScript")

    list.set(1, "Kotlin")
    println(list.getFirst() == "JavaScript")

    list.addFirst("Kotlin")
    println(list.getFirst() == "Kotlin")

    list.addLast("JavaScript")
    println(list.getFirst() == "Kotlin")

    println("getFirst method testing ended")
    println("==================================")
    println()
    println("Elements at LinkyList - $list")

    list.addFirst("Kotlin")
    println("Elements at LinkyList - $list")

    list.addFirst("Kotlin")
    println("Elements at LinkyList - $list")

    list.addFirst("Java")
    println("Elements at LinkyList - $list")

    list.addFirst("Python")
    println("Elements at LinkyList - $list")
}

fun testAdd3() {
    println()
    println("==================================")
    println("testAdd method testing started")
    val list = CircularLinkyList<String>()
    list.add("Kotlin")
    list.add("Java")
    list.add("C#")
    list.add("C")
    list.add("C++")
    println("Elements at LinkyList - $list")

    println()
    list.add(1, "JavaScript")
    println("Elements at LinkyList - $list")

    println()
    list.add(2, "TypeScript")
    println("Elements at LinkyList - $list")

    println()
    list.add(3, "CofeeScript")
    println("Elements at LinkyList - $list")

    println()
    list.add(7, "MongoDB")
    println("Elements at LinkyList - $list")

    println()
    list.add(0, "SQL")
    println("Elements at LinkyList - $list")

    println("testAdd method testing started")
    println("==================================")
}

fun testGet3() {
    println()
    println("=================================")
    println("Testing get started")
    val list = CircularLinkyList<String>()
    list.add("Kotlin")
    list.add("Java")
    list.add("C#")
    list.add("C")
    list.add("C++")

    println("0th Index - ${list.get(0)}")
    println("1st Index - ${list.get(1)}")
    println("2nd Index - ${list.get(2)}")
    println("3rd Index - ${list.get(3)}")
    println("4th Index - ${list.get(4)}")
    println("Testing get ended")
    println("=================================")
}

fun testSet3() {
    println()
    println("=================================")
    println("Testing set started")
    val list = CircularLinkyList<String>()
    list.add("Kotlin")
    list.add("Java")
    list.add("C#")
    list.add("C")
    list.add("C++")

    println("0th Index - ${list.set(0, "Edited Kotlin")}")
    println("1st Index - ${list.set(1, "Edited Java")}")
    println("2nd Index - ${list.set(2, "Edited C#")}")
    println("3rd Index - ${list.set(3, "Edited C")}")
    println("4th Index - ${list.set(4, "Edited C++")}")
    println("Final list - $list")
    println("Testing set ended")
    println("=================================")
}

fun testRemoveFirst3() {
    println()
    println("=================================")
    println("Testing removeFirst started")
    val list = CircularLinkyList<String>()
    list.add("Kotlin")
    list.add("Java")
    list.add("C#")
    list.add("C")
    list.add("C++")

    println("List - $list")
    list.removeFirst()
    println("List - $list")
    list.removeFirst()
    println("List - $list")
    list.removeFirst()
    println("List - $list")
    list.removeFirst()
    println("List - $list")
    list.removeFirst()
    println("List - $list")
    println("Testing removeFirst ended")
    println("=================================")
}

fun testRemoveLast3() {
    println()
    println("=================================")
    println("Testing removeLast started")
    val list = CircularLinkyList<String>()
    list.add("Kotlin")
    list.add("Java")
    list.add("C#")
    list.add("C")
    list.add("C++")

    println("List - $list")
    list.removeLast()
    println("List - $list")
    list.removeLast()
    println("List - $list")
    list.removeLast()
    println("List - $list")
    list.removeLast()
    println("List - $list")
    list.removeLast()
    println("List - $list")
    println("Testing removeLast ended")
    println("=================================")
}

fun testRemoveValue3() {
    println()
    println("=================================")
    println("Testing testRemoveValue started")
    val list = CircularLinkyList<String>()
    list.add("Kotlin")
    list.add("Java")
    list.add("C#")
    list.add("C")
    list.add("C++")

    println("JavaScript" in list)
    println("Kotlin" in list)

    println("List - $list")
    list.remove("Java")
    println("List - $list")
    list.remove("Kotlin")
    println("List - $list")
    list.remove("JavaScript")
    println("List - $list")
    list.remove("Python")
    println("List - $list")
    println("Testing testRemoveValue ended")
    println("=================================")
}