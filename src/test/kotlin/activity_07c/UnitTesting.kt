package activity_07c

import activity_07c.UnitTesting
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import kotlin.test.assertEquals

internal class UnitTesting {

    @Test
    fun successfulCheckOut() {
        val victorYu: Customer = Customer("Victor")
        victorYu.address = "QC"
        victorYu.lastName = "Yu"
        victorYu.mobileNumber = "9111111"
        victorYu.paymentDetails = "123456789123456"

        var chicken: Poultry = Poultry("Chicken", 290.0)
        chicken.stock = 100.0
        chicken.quantity = 1.0

        var pampano: Fish = Fish("Pampano", 400.0)
        pampano.stock = 10.0
        pampano.quantity = 1.0

        var cart: Cart = Cart(victorYu)
        cart.addItems(chicken)
        cart.addItems(pampano)

        assertEquals(690.0,cart.checkOut())
    }

    @Test
    fun incompleteCustomerDetails() {
        val victorYu: Customer = Customer("Victor")
        victorYu.paymentDetails = "123456789123456"

        var chicken: Poultry = Poultry("Chicken", 290.0)
        chicken.stock = 100.0
        chicken.quantity = 1.0

        var pampano: Fish = Fish("Pampano", 400.0)
        pampano.stock = 10.0
        pampano.quantity = 1.0

        var cart: Cart = Cart(victorYu)
        cart.addItems(chicken)
        cart.addItems(pampano)

        assertThrows<CartExceptions.CustomerRelatedExceptions.NoLoginDetails> {
            cart.checkOut()
        }
    }

    @Test
    fun noPaymentDetails() {
        val victorYu: Customer = Customer("Victor")
        victorYu.address = "QC"
        victorYu.lastName = "Yu"
        victorYu.mobileNumber = "9111111"

        var chicken: Poultry = Poultry("Chicken", 290.0)
        chicken.stock = 100.0
        chicken.quantity = 1.0

        var pampano: Fish = Fish("Pampano", 400.0)
        pampano.stock = 10.0
        pampano.quantity = 1.0

        var cart: Cart = Cart(victorYu)
        cart.addItems(chicken)
        cart.addItems(pampano)

        assertThrows<CartExceptions.CustomerRelatedExceptions.NoPaymentDetails> {
            cart.checkOut()
        }
    }

    @Test
    fun CartIsEmpty() {
        val victorYu: Customer = Customer("Victor")
        victorYu.address = "QC"
        victorYu.lastName = "Yu"
        victorYu.mobileNumber = "9111111"
        victorYu.paymentDetails = "123456789123456"

        var cart: Cart = Cart(victorYu)

        assertThrows<CartExceptions.CartRelatedExceptions.EmptyCart> {
            cart.checkOut()
        }
    }

    @Test
    fun StockOut() {
        val victorYu: Customer = Customer("Victor")
        victorYu.address = "QC"
        victorYu.lastName = "Yu"
        victorYu.mobileNumber = "9111111"
        victorYu.paymentDetails = "123456789123456"

        var chicken: Poultry = Poultry("Chicken", 290.0)
        chicken.stock = 100.0
        chicken.quantity = 1.0

        var pampano: Fish = Fish("Pampano", 400.0)
        pampano.stock = 0.5
        pampano.quantity = 1.0

        var cart: Cart = Cart(victorYu)
        cart.addItems(chicken)

        assertThrows<CartExceptions.CartRelatedExceptions.ItemStockOut> {
            cart.addItems(pampano)
        }
    }

    @Test
    fun NoVarietySelected() {
        val victorYu: Customer = Customer("Victor")
        victorYu.address = "QC"
        victorYu.lastName = "Yu"
        victorYu.mobileNumber = "9111111"
        victorYu.paymentDetails = "123456789123456"

        var itemWithNoTag: GroceryItems = GroceryItems("Unknown", 0.0)

        var cart: Cart = Cart(victorYu)

        assertThrows<CartExceptions.CartRelatedExceptions.NoItemVariationSelected> {
            cart.addItems(itemWithNoTag)
        }
    }
}