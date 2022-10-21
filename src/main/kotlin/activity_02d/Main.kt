package activity_02d

import mu.KotlinLogging

private val logger = KotlinLogging.logger {}
fun main() {

    //-----INTRO-----
    logger.info ("You will need to enter 5 monetary amounts that will be added together.")
    logger.info ("The sum of the 5 amounts you entered will then be divided by an integer you will input.")
    println()

    //-----VARIABLES-----
    var monetaryAmount = arrayOf<String?>("","","","","")
    var dividedByThis: String? = null
    var answer: Double? = null

    var validInput = false
    var allCharAnalyzed = false
    var decimalCounter = 0
    var wantMore: String? = null
    var more: Boolean = false


    do {
        for (masterIndex in 0..4) {
            when (masterIndex) {
                0 -> logger.info {"Please enter the first monetary amount: "}
                1 -> logger.info {"Please enter the second monetary amount: "}
                2 -> logger.info {"Please enter the third monetary amount: "}
                3 -> logger.info {"Please enter the fourth monetary amount: "}
                4 -> logger.info {"Please enter the fifth monetary amount: "}
            }
            do {
                monetaryAmount[masterIndex] = readLine()
                decimalCounter = 0
                if (monetaryAmount[masterIndex] == null || monetaryAmount[masterIndex] == "") {
                    validInput = false
                    allCharAnalyzed = true
                    logger.error ("You did not enter anything.")
                    logger.info ("Please re-enter the first monetary amount: ")
                } else {
                    for (index in monetaryAmount[masterIndex]!!.indices) {
                        var char = monetaryAmount[masterIndex]!![index]
                        if (index == 0) {
                            if (char == '-') {
                                if (monetaryAmount[masterIndex]!!.length < 2) {
                                    validInput = false
                                } else {
                                    validInput = monetaryAmount[masterIndex]!![1].isDigit()
                                }
                            } else {
                                validInput = char.isDigit()
                            }
                        } else {
                            if (validInput) {
                                if ((char == '.') && (decimalCounter == 0)) {
                                    validInput = monetaryAmount[masterIndex]!![index - 1].isDigit()
                                    decimalCounter++
                                } else {
                                    when (decimalCounter) {
                                        0 -> {
                                            validInput = char.isDigit()
                                        }

                                        in 1..2 -> {
                                            validInput = char.isDigit()
                                            decimalCounter++
                                        }

                                        else -> {
                                            validInput = false
                                        }
                                    }
                                }
                            }
                        }
                        if (index == monetaryAmount[masterIndex]!!.length - 1 && validInput) {
                            allCharAnalyzed = true
                        }
                    }
                    if (!validInput) {
                        logger.error ("Your input was not a monetary value. ")
                        logger.info ("Please re-enter the first monetary amount: ")
                    }
                }
            } while (!allCharAnalyzed || !validInput)
        }
//        validInput = false
//        allCharAnalyzed = false
//        decimalCounter = 0

        logger.info ("Divide the value by how many? ")
        do {
            dividedByThis = readLine()
            if (dividedByThis == null || dividedByThis == "") {
                validInput = false
                allCharAnalyzed = true
                logger.error ("You did not enter anything.")
                logger.info ("Please re-enter the divisor: ")
            } else {
                for (index in dividedByThis.indices) {
                    var char = dividedByThis[index]
                    if (index == 0) {
                        if (char == '-') {
                            if (dividedByThis.length < 2) {
                                validInput = false
                            } else {
                                validInput = dividedByThis[1].isDigit()
                            }
                        } else {
                            validInput = char.isDigit()
                        }
                    } else {
                        if (validInput) {
                            validInput = char.isDigit()
                        }
                    }
                    if (index == dividedByThis.length - 1 && validInput) {
                        allCharAnalyzed = true
                    }
                }
                if (!validInput) {
                    logger.error ("Your input was not an integer. ")
                    logger.info ("Please re-enter the divisor (integer): ")
                }
            }
        } while (!allCharAnalyzed || !validInput)

        //-----OPERATION-----
        answer =
            (monetaryAmount[0]!!.toDouble() + monetaryAmount[1]!!.toDouble() + monetaryAmount[2]!!.toDouble() + monetaryAmount[3]!!.toDouble() + monetaryAmount[4]!!.toDouble()) / dividedByThis!!.toDouble()
        logger.info ("The answer is $answer.")
        println()
        logger.info ("Would you like to do another set? [Y/N] ")
        wantMore = readLine()
        if (wantMore == null || wantMore == "") {
            logger.error ("I'll take no response as a NO. B-bye!")
            more = false
        } else when(wantMore.lowercase()) {
            "y" -> {
                logger.info ("One more round!!!")
                println()
                more = true
            }
            "n" -> {
                logger.info ("Thank you for using this program!")
                more = false
            }
            else -> {
                logger.error ("Is this a test? Did I pass? :D I'm really tired, so I'm ending the program now.")
                more = false
            }
        }
    }while (more)
    println()
    logger.debug ("Activity 02-D | Submitted by: Victor Yu Jr.")
}