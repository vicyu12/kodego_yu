package activity_01b

import java.security.KeyStore.TrustedCertificateEntry

/*
You are tasked to automate a school’s library.

Identify the items that can be borrowed in a Library.

After listing the different items, identify the characteristics of the items.

Use the proper data types.
 */

fun main() {
    val book1: String = "A Book About Algebra"
//    val book1DeweyDecimal: String = "512"
    var book1Availability: Boolean = true
    var book1Characteristics: String? = "Reader friendly"

    val book2: String = "A French Dictionary"
//    val book2DeweyDecimal: String = "443"
    val book2Availability: Boolean = true
    var book2Characteristics: String? = "Brand new"

    val book3: String = "A Book on Religion"
//    val book3DeweyDecimal: String = "200"
    val book3Availability: Boolean = true
    var book3Characteristics: String? = null
}