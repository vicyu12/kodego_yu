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
    val alphabet = ArrayList<Char>()
    val letterCount = ArrayList<Int>()
    val uniqueCharacters = ArrayList<Char>()
    var char: Char? = null

    logger.info { "Enter a first string:" }
    string1 = readLine()
    logger.info { "Enter another string:" }
    string2 = readLine()

    if (string1 == null || string2 == null) {
        logger.error { "You were missing an input." }
    } else {
        for (index in string1.indices) {
            char = string1[index].uppercaseChar()
            if (alphabet.isEmpty() || char !in alphabet) {
                alphabet.add(char)
                letterCount.add(1)
            } else {
                for (letterIndex in alphabet.indices) {
                    if (char == alphabet[letterIndex]) letterCount[letterIndex]++
                }
            }
        }
        for (index in string2.indices) {
            char = string2[index].uppercaseChar()
            if (alphabet.isEmpty() || char !in alphabet) {
                alphabet.add(char)
                letterCount.add(1)
            } else {
                for (letterIndex in alphabet.indices) {
                    if (char == alphabet[letterIndex]) letterCount[letterIndex]++
                }
            }
        }
    }
    for (index in alphabet.indices) {
        if (letterCount[index] == 1) {
            uniqueCharacters.add(alphabet[index])
        }
    }
    for (index in uniqueCharacters.indices) {
        logger.info { "Unique character found: ${uniqueCharacters[index]}" }
    }
}