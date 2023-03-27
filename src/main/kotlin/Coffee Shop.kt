data class Coffee(val name: String, val size: String, val price: Double)

class CoffeeShop(private val menu: Map<String, Map<String,Double>>) {
    private val orders = mutableListOf<Coffee>()
    fun addOrder(name: String, size: String) {
        val price = menu[name]?.get(size)
        if (price != null) {
            val coffee = Coffee(name, size, price)
            orders.add(coffee)
            println("Added $size $name to your cart.")
        } else {
            println("Invalid coffee or size.")
        }
    }

    fun printBill() {
        if (orders.isNotEmpty()) {
            val total = orders.sumOf { it.price }
            val rewardsPoints = (total / 150).toInt()
            println("-------BILL--------")
            orders.forEach { println("${it.size} ${it.name}\t${"%.2f".format(it.price)}") }
            println("--------------------")
            println("Total:\t\t${"%.2f".format(total)}")
            println("Rewards Points:\t$rewardsPoints")
            println("--------------------")
        } else {
            println("No items in cart.")
        }
    }
}
