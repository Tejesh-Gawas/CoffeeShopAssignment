import java.util.*

fun main() {
    val menu = mapOf(
        "Black_Coffee" to mapOf("Small" to 100.0, "Medium" to 150.0, "Large" to 200.0),
        "Cold_Coffee" to mapOf("Small" to 120.0, "Medium" to 180.0, "Large" to 220.0),
        "Hot_Coffee" to mapOf("Small" to 120.0, "Medium" to 180.0, "Large" to 220.0),
        "Cappuccino" to mapOf("Small" to 150.0, "Medium" to 200.0, "Large" to 250.0))

    val coffeeShop = CoffeeShop(menu)

    val scanner = Scanner(System.`in`)
    var choice: Int

    do {
        println("COFFEE SHOP MENU:")
        println("1. View Menu")
        println("2. Add Item to Cart")
        println("3. Print Bill")
        println("4. Exit")

        print("Enter your choice: ")
        choice = scanner.nextInt()

        when (choice) {
            1 -> {
                println("MENU:")
                menu.forEach { (coffee, sizes) ->
                    println("$coffee:")
                    sizes.forEach { (size, price) ->
                        println("\t- $size: Rs${(price)}")
                    }
                }
            }
            2 -> {
                println("What coffee would you like to order?")
                scanner.nextLine()
                val coffee = scanner.nextLine()
                println("What size would you like?")
                val size = scanner.next()
               // println("$coffee : $size...")
               coffeeShop.addOrder(coffee, size)
            }
            3 -> {
                coffeeShop.printBill()
            }
            4 -> {
                println("Goodbye!")
            }
            else -> {
                println("Invalid choice. Please try again.")
            }
        }
    } while (choice != 4)
}
