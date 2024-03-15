package ds.m3

fun main(args: Array<String>) {
    val linkyList = SinglyLinkyList<String>()
    println("First item of the linky list is - ${linkyList.getFirst()}")
    println("Last item of the linky list is - ${linkyList.getLast()}")

    println()
    linkyList.add("Kotlin")
    println("First item of the linky list is - ${linkyList.getFirst()}")
    println("Last item of the linky list is - ${linkyList.getLast()}")

    println()
    linkyList.add("Java")
    println("First item of the linky list is - ${linkyList.getFirst()}")
    println("Last item of the linky list is - ${linkyList.getLast()}")

    linkyList.add("C#")
    linkyList.add("Python")
    linkyList.add("JavaScript")

    println()
    println("Elements at linkyList - $linkyList")
    linkyList.remove("JavaScript")
    println("Elements at linkyList after removing JavaScript - $linkyList")
    linkyList.remove("Kotlin")
    println("Elements at linkyList after removing Kotlin - $linkyList")
    linkyList.remove("C#")
    println("Elements at linkyList after removing C# - $linkyList")
    linkyList.remove("Java")
    println("Elements at linkyList after removing Java - $linkyList")
    linkyList.remove("Python")
    println("Elements at linkyList after removing Python - $linkyList")

    testGetFirst()
    testAddV2()
    testGet()
    testSet()
    testRemoveFirst()
    testRemoveLast()
    testRemoveValue()
    testAddAll()
}

fun testGetFirst() {
    println()
    println("==================================")
    println("getFirst method testing started")
    val linkyList = SinglyLinkyList<String>()
    println(linkyList.getFirst() == null)

    linkyList.add("Kotlin")
    println(linkyList.getFirst() == "Kotlin")

    linkyList.add("Java")
    println(linkyList.getFirst() == "Kotlin")

    linkyList.add("Python")
    println(linkyList.getFirst() == "Kotlin")

    linkyList.add(0, "Python")
    println(linkyList.getFirst() == "Python")

    linkyList.add(1, "JavaScript")
    println(linkyList.getFirst() == "Python")

    linkyList.set(0, "JavaScript")
    println(linkyList.getFirst() == "JavaScript")

    linkyList.set(1, "Kotlin")
    println(linkyList.getFirst() == "JavaScript")

    linkyList.addFirst("Kotlin")
    println(linkyList.getFirst() == "Kotlin")

    linkyList.addLast("JavaScript")
    println(linkyList.getFirst() == "Kotlin")

    println("getFirst method testing ended")
    println("==================================")
    println()
    linkyList.clear()
    println("Elements at LinkyList - $linkyList")

    linkyList.addFirst("Kotlin")
    println("Elements at LinkyList - $linkyList")

    linkyList.addFirst("Kotlin")
    println("Elements at LinkyList - $linkyList")

    linkyList.addFirst("Java")
    println("Elements at LinkyList - $linkyList")

    linkyList.addFirst("Python")
    println("Elements at LinkyList - $linkyList")
}

fun testAddV2() {
    println()
    println("==================================")
    println("testAddV2 method testing started")
    val linkyList = SinglyLinkyList<String>()
    linkyList.add("Kotlin")
    linkyList.add("Java")
    linkyList.add("C#")
    linkyList.add("C")
    linkyList.add("C++")
    println("Elements at LinkyList - $linkyList")

    println()
    linkyList.addV2(1, "JavaScript")
    println("Elements at LinkyList - $linkyList")

    println()
    linkyList.addV2(2, "TypeScript")
    println("Elements at LinkyList - $linkyList")

    println()
    linkyList.addV2(3, "CofeeScript")
    println("Elements at LinkyList - $linkyList")

    println()
    linkyList.addV2(7, "MongoDB")
    println("Elements at LinkyList - $linkyList")

    println()
    linkyList.addV2(0, "SQL")
    println("Elements at LinkyList - $linkyList")

    println("testAddV2 method testing started")
    println("==================================")
}

fun testGet() {
    println()
    println("=================================")
    println("Testing get started")
    val linkyList = SinglyLinkyList<String>()
    linkyList.add("Kotlin")
    linkyList.add("Java")
    linkyList.add("C#")
    linkyList.add("C")
    linkyList.add("C++")

    println("0th Index - ${linkyList.get(0)}")
    println("1st Index - ${linkyList.get(1)}")
    println("2nd Index - ${linkyList.get(2)}")
    println("3rd Index - ${linkyList.get(3)}")
    println("4th Index - ${linkyList.get(4)}")
    println("Testing get ended")
    println("=================================")
}

fun testSet() {
    println()
    println("=================================")
    println("Testing set started")
    val linkyList = SinglyLinkyList<String>()
    linkyList.add("Kotlin")
    linkyList.add("Java")
    linkyList.add("C#")
    linkyList.add("C")
    linkyList.add("C++")

    println("0th Index - ${linkyList.set(0, "Edited Kotlin")}")
    println("1st Index - ${linkyList.set(1, "Edited Java")}")
    println("2nd Index - ${linkyList.set(2, "Edited C#")}")
    println("3rd Index - ${linkyList.set(3, "Edited C")}")
    println("4th Index - ${linkyList.set(4, "Edited C++")}")
    println("Final list - $linkyList")
    println("Testing set ended")
    println("=================================")
}

fun testRemoveFirst() {
    println()
    println("=================================")
    println("Testing removeFirst started")
    val linkyList = SinglyLinkyList<String>()
    linkyList.add("Kotlin")
    linkyList.add("Java")
    linkyList.add("C#")
    linkyList.add("C")
    linkyList.add("C++")

    println("List - $linkyList")
    linkyList.removeFirst()
    println("List - $linkyList")
    linkyList.removeFirst()
    println("List - $linkyList")
    linkyList.removeFirst()
    println("List - $linkyList")
    linkyList.removeFirst()
    println("List - $linkyList")
    println("Testing removeFirst ended")
    println("=================================")
}

fun testRemoveLast() {
    println()
    println("=================================")
    println("Testing removeLast started")
    val linkyList = SinglyLinkyList<String>()
    linkyList.add("Kotlin")
    linkyList.add("Java")
    linkyList.add("C#")
    linkyList.add("C")
    linkyList.add("C++")

    println("List - $linkyList")
    linkyList.removeLast()
    println("List - $linkyList")
    linkyList.removeLast()
    println("List - $linkyList")
    linkyList.removeLast()
    println("List - $linkyList")
    linkyList.removeLast()
    println("List - $linkyList")
    println("Testing removeLast ended")
    println("=================================")
}

fun testRemoveValue() {
    println()
    println("=================================")
    println("Testing testRemoveValue started")
    val linkyList = SinglyLinkyList<String>()
    linkyList.add("Kotlin")
    linkyList.add("Java")
    linkyList.add("C#")
    linkyList.add("C")
    linkyList.add("C++")

    println("JavaScript" in linkyList)
    println("Kotlin" in linkyList)

    println("List - $linkyList")
    linkyList.remove("Java")
    println("List - $linkyList")
    linkyList.remove("Kotlin")
    println("List - $linkyList")
    linkyList.remove("JavaScript")
    println("List - $linkyList")
    linkyList.remove("Python")
    println("List - $linkyList")
    println("Testing testRemoveValue ended")
    println("=================================")
}

fun testAddAll() {
    println()
    println("=================================")
    println("Testing testAddAll started")

    val linkyList = SinglyLinkyList<String>()

    // Add few elements at begining of the linkedlist
    linkyList.addAll(0, arrayOf<String>("C", "C++"))
    println("List - $linkyList")
    linkyList.addAll(0, arrayOf<String>("Java", "Kotlin"))
    println("List - $linkyList")
    // Add few elements at middle of the linkedlist
    linkyList.addAll(2, arrayOf<String>("Python", "R"))
    println("List - $linkyList")
    // Add few elements at end of the linkedlist
    linkyList.addAll(linkyList.size(), arrayOf<String>("C#", "MATLAB"))
    println("List - $linkyList")
    println("Testing testAddAll ended")
    println("=================================")
}