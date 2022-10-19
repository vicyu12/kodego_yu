package activity_01g

import mu.KotlinLogging

private val logger = KotlinLogging.logger {}

fun main() {
    var string: String? = null
    var palindrome = ArrayList<Boolean>()
    var palindromeCounter: Int? = null
    var palindromeFinal: Boolean = true

    logger.info { "Please enter a string:" }
    string = readLine()
    if (string == null || string == "") {
        logger.error { "You did not input anything." }
    } else {
        for (index in 0 until string.length/2)
        {
            palindromeCounter = string.length - index -1
            palindrome.add(string[index].lowercaseChar() == string[palindromeCounter].lowercaseChar())
        }
        for (index in palindrome.indices) {
            palindromeFinal = palindromeFinal && palindrome[index]
        }
    }
    if (palindromeFinal) {
        logger.info { "Palindrome!" }
    } else {
        logger.info {"This is not a Palindrome."}
    }
}