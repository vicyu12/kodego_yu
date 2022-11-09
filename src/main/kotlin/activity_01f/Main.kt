package activity_01f

import mu.KotlinLogging

private val logger = KotlinLogging.logger {}
fun main() {
    /*
    Create an application that will accept 2 string inputs.
    Your application will print all unique characters in both strings.
     */

    var string1: String? = null
    var string2: String? = null
    var uniqueCharacters: String = ""
    var bothStrings: String? = null

    logger.info { "Enter a first string:" }
    string1 = readLine()
    logger.info { "Enter another string:" }
    string2 = readLine()

    if (string1 == null || string2 == null) {
        logger.error { "You were missing an input." }
    } else {
        bothStrings = string1 + string2
        for (char in bothStrings) {
            if (char.toString().lowercase() !in uniqueCharacters.lowercase()) {
                uniqueCharacters += char
            }
        }
    }
    logger.info { "Unique characters: $uniqueCharacters" }
}