package activity_01h

import mu.KotlinLogging

private val logger = KotlinLogging.logger {}

fun main() {
    var firstNumber: Int? = null
    var secondNumber: Int? = null
    var lowerNumber: Int? = null
    var biggerNumber: Int? = null
    var isPrimeNumber: Boolean = true
    var primeNumber = ArrayList<Int>()

    logger.info { "Please input an integer:" }
    firstNumber = readLine()?.toIntOrNull()
    logger.info { "Please input another integer" }
    secondNumber = readLine()?.toIntOrNull()

    if (firstNumber == null || secondNumber == null) {
        logger.error { "Something's wrong with your input" }
    } else {
        if (firstNumber >= secondNumber) {
            lowerNumber = secondNumber
            biggerNumber = firstNumber
        } else {
            lowerNumber = firstNumber
            biggerNumber = secondNumber
        }
        for (number in lowerNumber .. biggerNumber) {
            isPrimeNumber = true
            for (divisor in 2 until number) {
                if (number%divisor == 0) {
                    isPrimeNumber = false
                }
            }
            if (isPrimeNumber) {
                logger.info { number }
            }
        }
    }
}