package activity_06c

fun main() {
    val victorYu: Customer = Customer("Victor")
    victorYu.address = "QC"
    victorYu.lastName = "Yu"
    victorYu.mobileNumber = "9111111"
    victorYu.paymentDetails = "123456789123456"

    var itemWithNoTag: GroceryItems = GroceryItems("Unknown", 0.0)

    var chicken: Poultry = Poultry("Chicken", 290.0)
    chicken.stock = 100.0
    chicken.quantity = 1.0

    var pampano: Fish = Fish("Pampano", 400.0)
    pampano.stock = 10.0
//    pampano.stock = 0.5
    pampano.quantity = 1.0

    var cart: Cart = Cart(victorYu)
    cart.addItems(itemWithNoTag)
    cart.addItems(chicken)
    cart.addItems(pampano)

    cart.checkOut()
}