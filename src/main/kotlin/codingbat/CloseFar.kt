package codingbat

import kotlin.math.abs

fun main() {
    var a: String? = null
    var b: String? = null
    var c: String? = null
    var aMinusB: Int = 0
    var bMinusC: Int = 0
    var cMinusA: Int = 0
    var i: Boolean = false
    var j: Boolean = false
    var k: Boolean = false
    var x: Boolean? = null
    var y: Boolean? = null
    var z: Boolean? = null
    var l: Boolean? = null
    var m: Boolean? = null
    var n: Boolean? = null

    print("Enter a number: ")
    a = readLine()
    print("Enter a second number: ")
    b = readLine()
    print("Enter a third number: ")
    c = readLine()

    if (a == null || b == null || c == null || a == "" || b == "" || c == "") {
        println("You did not input at least 1 number.")
    } else if (a.all { Char -> Char.isDigit()} && b.all { Char -> Char.isDigit()} && c.all { Char -> Char.isDigit()}) {
        aMinusB = abs(a.toInt() - b.toInt())
        bMinusC = abs(b.toInt() - c.toInt())
        cMinusA = abs(c.toInt() - a.toInt())
        if (aMinusB in 0..1) i = true
        if (bMinusC in 0..1) j = true
        if (cMinusA in 0..1) k = true

        if (i == true && j == true && k == true) n = false
        else {
            x = i || j
            y = !(i && j)
            z = x && y

            l = k || z
            m = !(k && z)
            n = l && m
        }
        println(n)

    } else println("You entered a non-digit character.")

}