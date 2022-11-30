package activity_06c

open class GroceryItems {
    var name: String = ""
        private set
    var price: Double = 0.0
    var quantity: Double = 0.0

    constructor(name: String, price: Double) {
        this.name = name
        this.price = price
    }
}

class Poultry(name: String, price: Double): GroceryItems(name, price) {
    var stock: Double = 0.0
}

class Fish(name: String, price: Double): GroceryItems(name, price) {
    var stock: Double = 0.0
}

class CannedGoods(name: String, price: Double): GroceryItems(name, price) {
    var stock: Int = 0
}

class Snacks(name: String, price: Double): GroceryItems(name, price) {
    var stock: Int = 0
}

class Sodas(name: String, price: Double): GroceryItems(name, price) {
    var stock: Int = 0
}

class Cart(customer: Customer) {
    val customer: Customer = customer
    var uniqueID: String = ""
    var items: HashMap<GroceryItems, Any> = HashMap()

    fun addItems(groceryItems: GroceryItems) {
        items[groceryItems] = groceryItems.quantity
    }

    fun checkOut() {
        var grandTotal: Double = 0.0

        if (this.customer.address == "" || this.customer.firstName == "" || this.customer.lastName == "" || this.customer.mobileNumber == "") {
            throw CartExceptions.CustomerRelatedExceptions.NoLoginDetails()
        }
        if (this.customer.paymentDetails == "") {
            throw CartExceptions.CustomerRelatedExceptions.NoPaymentDetails()
        }
        if (this.items.size<1) {
            throw CartExceptions.CartRelatedExceptions.EmptyCart()
        }
        items.keys.forEach {
            when(it) {
                is Poultry -> {
                    if (it.quantity > it.stock) {
                        throw CartExceptions.CartRelatedExceptions.ItemStockOut()
                    } else {
                        grandTotal += it.quantity * it.price
                    }
                }
                is Fish -> {
                    if (it.quantity > it.stock) {
                        throw CartExceptions.CartRelatedExceptions.ItemStockOut()
                    } else {
                        grandTotal += it.quantity * it.price
                    }
                }
                is CannedGoods -> {
                    if (it.quantity > it.stock) {
                        throw CartExceptions.CartRelatedExceptions.ItemStockOut()
                    } else {
                        grandTotal += it.quantity * it.price
                    }
                }
                is Snacks -> {
                    if (it.quantity > it.stock) {
                        throw CartExceptions.CartRelatedExceptions.ItemStockOut()
                    } else {
                        grandTotal += it.quantity * it.price
                    }
                }
                is Sodas -> {
                    if (it.quantity > it.stock) {
                        throw CartExceptions.CartRelatedExceptions.ItemStockOut()
                    } else {
                        grandTotal += it.quantity * it.price
                    }
                }
                else -> {
                    throw CartExceptions.CartRelatedExceptions.NoItemVariationSelected()
                }
            }
        }
        println("Grand Total of Cart is $grandTotal")
    }
}

sealed class CartExceptions(message: String): Exception(message) {
    sealed class CustomerRelatedExceptions(message: String): Exception(message) {
        class NoLoginDetails(message: String = "Incomplete Customer Details."): Exception(message)
        class NoPaymentDetails(message: String = "No Payment Details."): Exception(message)
    }
    sealed class CartRelatedExceptions {
        class EmptyCart(message: String = "The Cart is Empty."): Exception(message)
        class ItemStockOut(message: String = "The Stock cannot support the Order Quantity"): Exception(message)
        class NoItemVariationSelected(message: String = "No Item Variation Selected"): Exception(message)
    }
}


data class Customer(var firstName: String) {
    var lastName: String = ""
    var address: String = ""
    var mobileNumber: String = ""
    var paymentDetails: String = ""
}