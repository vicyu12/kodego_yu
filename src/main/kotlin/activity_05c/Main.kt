package activity_05c

fun main() {
    var cart: Cart = Cart()


    val chicken: Poultry =  Poultry("0000000001", 300.0)

    chicken.orderQuantity = 5.0
    cart.addToCart(chicken)
    println(cart.cart)

    chicken.orderQuantity = 10.0
    cart.addToCart(chicken)
    println(cart.cart)

    val tilapia: Fish = Fish("0000000002", 190.0)

    tilapia.orderQuantity = 2.0
    cart.addToCart(tilapia)
    println(cart.cart)

    cart.removeFromCart(chicken)
    println(cart.cart)

    val cornedBeef: CannedGoods = CannedGoods("0000000003", 110.0)
    cornedBeef.orderQuantity = 1.0
    cart.addToCart(cornedBeef)
    println(cart.cart)

    cart.checkOutCart()

}