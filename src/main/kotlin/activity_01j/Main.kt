package activity_01j

import mu.KotlinLogging
import kotlin.math.log

private val logger = KotlinLogging.logger {}

fun main() {
    var itemName: String? = null
    var itemQuantity: Int? = null
    var itemCost: Double? = null
    var itemNameBought = ArrayList<String>()
    var itemQuantityBought = ArrayList<Int>()
    var itemCostBought = ArrayList<Double>()
    var totalCost:Double = 0.0
    var getTotal = false
    var matchIndex: Int = 0
    var matchFound: Boolean = false
    var getTotalYN: String? = null

    do {
        logger.info { "Enter the Item Name: " }
        itemName = readLine()
        logger.info { "How much does $itemName cost?" }
        itemCost = readLine()?.toDoubleOrNull()
        logger.info { "How many of $itemName will be bought?" }
        itemQuantity = readLine()?.toIntOrNull()

        if (itemName == null || itemName == "" || itemCost == null || itemQuantity == null) {
            logger.error { "There's something wrong with your input. Please re-enter:" }
            getTotal = false
        } else {
            if (itemNameBought.isEmpty() || itemName !in itemNameBought || itemCost !in itemCostBought) {
                itemNameBought.add(itemName)
                itemCostBought.add(itemCost)
                itemQuantityBought.add(itemQuantity)
            }else {
                matchIndex = 0
                do {
                    if (itemName == itemNameBought[matchIndex] && itemCost == itemCostBought[matchIndex]) {
                        matchFound = true
                        itemQuantityBought[matchIndex] += itemQuantity
                    }
                    matchIndex ++
                    if (matchIndex == itemNameBought.size && !matchFound) {
                        itemNameBought.add(itemName)
                        itemCostBought.add(itemCost)
                        itemQuantityBought.add(itemQuantity)
                    }
                }while (!matchFound)
            }
        }
        logger.info { "Would you like to get the total? [Y/N]" }
        getTotalYN = readLine()
        when (getTotalYN?.uppercase()) {
            "Y" -> getTotal = true
            else -> getTotal = false
        }
    }while (!getTotal)
    logger.info { "Item Name | Quantity | Cost/piece" }
    for (index in itemNameBought.indices) {
        logger.info { "${itemNameBought[index]} | ${itemQuantityBought[index]} | ${itemCostBought[index]}" }
        totalCost += itemQuantityBought[index] * itemCostBought[index]
    }
    logger.info { "Total Cost: $totalCost" }
}