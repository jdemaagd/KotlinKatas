package ds.m2

fun main() {
    val companies = arrayListOf<String>("Google", "Microsoft", "Facebook", "Apple", "JetBrains")
    companies.add("Amazon")
    companies.add("Samsung")
    companies.set(2, "Twitter")
    companies.remove("Samsung")
    companies.removeAt(2)

    val days = listOf("Sunday", "Monday", "Tuesday", "Wednesday")
    val months = arrayListOf("January", "February", "March", "April")

    val modifiedDays = days + "Thursday"
    months.add("May")

    val numbers = arrayOf(
        arrayOf(1, 2, 3),
        arrayOf(4, 5, 6),
        arrayOf(7, 8, 9)
    )

    val food = arrayOf(
        arrayOf("Apple", "Apricot", "Avocado"),
        arrayOf("Banana", "Broccoli", "Beetroot"),
        arrayOf("Cherry", "Carrot")
    )

    val row1 = food[0]
    val row2 = food[1]

    val firstFoodWithA = row1[0]
    val firstFoodWithB = row2[0]

    println("2nd food item which starts from B is : ${food[1][1]}")
    println("2nd food item which starts from C is : ${food[2][1]}")

    food[0] = arrayOf("Date", "Damson", "Durian")

    food[2][1] = "Coconut"

    for (row in food) {
        print("Item : ")
        for (item in row) {
            print("$item ")
        }
        println()
    }
}