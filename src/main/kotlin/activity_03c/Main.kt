package activity_03c

import mu.KotlinLogging

private val logger = KotlinLogging.logger {}

var grocery = ArrayList<String>()
var cart = HashMap<String, Int>()

fun main() {

    logger.info { "Adding a dozen of Eggs." }
    addToCart("Eggs", 12)
    logger.info { "Checkout: ${checkOut()}" }
    println()
    logger.info { "Adding 24 pcs of Coke in can." }
    addToCart("Coke", 24)
    logger.info { "Checkout: ${checkOut()}" }
    println()
    logger.info { "Re-adding 10pcs of Coke in can." }
    addToCart("Coke", 10)
    logger.info { "Checkout: ${checkOut()}" }
    println()
    logger.info { "Removing Coke from the list" }
    removeFromCart("Coke")
    logger.info { "Checkout: ${checkOut()}" }

}

fun addToCart(key: String, value: Int): Unit {

    var suffix: Int = 0
    var newKey: String = key

    while (newKey in cart) {
        newKey = newKey + "_" + suffix.toString()
        suffix++
    }

    cart.put(newKey,value)
}

fun checkOut(): Int {
    var itemsCheckedOut: Int = 0
    for (value in cart.values) {
        itemsCheckedOut += value
    }
    return itemsCheckedOut
}

fun removeFromCart(key: String) {
    var suffix: Int = 0
    var newKey: String = key
    do {
        cart.remove(newKey)
        newKey = newKey + "_" + suffix.toString()
        suffix++
    }while (newKey in cart)


}