package activity_05c

import classroom_notes.CalculatorErrors

open class GroceryItems(barcode: String, price: Double) {
    val barcode: String = barcode
    val price: Double = price
    var orderQuantity: Double = 0.0
}

class Cart {
    var cart: HashMap<String, Double> = HashMap()

    fun addToCart(groceryItems: GroceryItems) {
        val item: String = groceryItems.barcode
        var totalOrderQuantity = (cart[item]?.div((groceryItems.price)) ?: 0.0) + (groceryItems.orderQuantity)
        var amount: Double = groceryItems.price * totalOrderQuantity
        cart[item] = amount
    }

    fun removeFromCart(groceryItems: GroceryItems) {
        val item: String = groceryItems.barcode
        cart.remove(item)
    }

    fun checkOutCart() {
        var cartTotal: Double = 0.0
        cart.keys.forEach {
            cartTotal += cart[it]!!
        }
        println("The grand total of this cart is $cartTotal")
    }
}

class Poultry(barcode: String, price: Double): GroceryItems(barcode, price) {
    var brand: String = ""
    var weight: Double = 0.0
    var pricePerKilo: Double = 0.0
    var type: String = ""
    var quantity: Double = 0.0
}

class Fish(barcode: String, price: Double): GroceryItems(barcode, price) {
    var brand: String = ""
    var weight: Double = 0.0
    var pricePerKilo: Double = 0.0
    var type: String = ""
    var quantity: Double = 0.0
    var freshWater: Boolean = true
}

class CannedGoods(barcode: String, price: Double): GroceryItems(barcode, price) {
    var type: String = ""
    var brand: String = ""
    var variety: String = ""
    var size: String = ""
    var name: String = ""
}

class Snacks(barcode: String, price: Double): GroceryItems(barcode, price) {
    var type: String = ""
    var brand: String = ""
    var variety: String = ""
    var size: String = ""
    var name: String = ""
}

class FrozenProducts(barcode: String, price: Double): GroceryItems(barcode, price) {
    var type: String = ""
    var brand: String = ""
    var variety: String = ""
    var size: String = ""
    var name: String = ""
}

class Fruits(barcode: String, price: Double): GroceryItems(barcode, price) {
    var brand: String = ""
    var weight: Double = 0.0
    var pricePerKilo: Double = 0.0
    var type: String = ""
    var quantity: Double = 0.0
}

class Vegetables(barcode: String, price: Double): GroceryItems(barcode, price) {
    var brand: String = ""
    var weight: Double = 0.0
    var pricePerKilo: Double = 0.0
    var type: String = ""
    var quantity: Double = 0.0
}

class Condiments(barcode: String, price: Double): GroceryItems(barcode, price) {
    var type: String = ""
    var brand: String = ""
    var variety: String = ""
    var size: String = ""
    var name: String = ""
}

class Furniture(barcode: String, price: Double): GroceryItems(barcode, price) {
    var type: String = ""
    var brand: String = ""
    var variety: String = ""
    var size: String = ""
    var name: String = ""
}

class Appliances(barcode: String, price: Double): GroceryItems(barcode, price) {
    var type: String = ""
    var brand: String = ""
    var variety: String = ""
    var size: String = ""
    var name: String = ""
}

class Clothes(barcode: String, price: Double): GroceryItems(barcode, price) {
    var type: String = ""
    var brand: String = ""
    var variety: String = ""
    var size: String = ""
}

class Pet(barcode: String, price: Double): GroceryItems(barcode, price) {
    var type: String = ""
    var brand: String = ""
    var variety: String = ""
    var size: String = ""
    var name: String = ""
}

class SanitaryProducts(barcode: String, price: Double): GroceryItems(barcode, price) {
    var type: String = ""
    var brand: String = ""
    var variety: String = ""
    var size: String = ""
    var name: String = ""
}

class PersonalCare(barcode: String, price: Double): GroceryItems(barcode, price) {
    var type: String = ""
    var brand: String = ""
    var variety: String = ""
    var size: String = ""
    var name: String = ""
}

class Sodas(barcode: String, price: Double): GroceryItems(barcode, price) {
    var type: String = ""
    var brand: String = ""
    var variety: String = ""
    var size: String = ""
    var name: String = ""
}

class Chips(barcode: String, price: Double): GroceryItems(barcode, price) {
    var type: String = ""
    var brand: String = ""
    var variety: String = ""
    var size: String = ""
    var name: String = ""
}

class Wheat(barcode: String, price: Double): GroceryItems(barcode, price) {
    var type: String = ""
    var brand: String = ""
    var variety: String = ""
    var size: String = ""
    var name: String = ""
}

class Dairy(barcode: String, price: Double): GroceryItems(barcode, price) {
    var type: String = ""
    var brand: String = ""
    var variety: String = ""
    var size: String = ""
    var name: String = ""
}

class CigarettesAndVapes(barcode: String, price: Double): GroceryItems(barcode, price) {
    var type: String = ""
    var brand: String = ""
    var variety: String = ""
    var size: String = ""
    var name: String = ""
}