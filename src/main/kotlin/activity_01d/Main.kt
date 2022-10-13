package activity_01d

fun main() {

    //-----INTRO-----
    println("You will need to enter 5 monetary amounts that will be added together.")
    println("The sum of the 5 amounts you entered will then be divided by an integer you will input.")
    println()

    //-----VARIABLES-----
    var monetaryAmount1: String? = null
    var monetaryAmount2: String? = null
    var monetaryAmount3: String? = null
    var monetaryAmount4: String? = null
    var monetaryAmount5: String? = null
    var dividedByThis: String? = null
    var answer: Double? = null

//    SCRAPPING THIS AND USING STUFF LEARNED FROM CLASS
//    var numericCheck1: Boolean? = null
//    var numericCheck2: Boolean? = null
//    var numericCheck3: Boolean? = null
//    var numericCheck4: Boolean? = null
//    var numericCheck5: Boolean? = null
//    var intCheck: Boolean? = null
    var validInput = false
    var allCharAnalyzed = false
    var decimalCounter = 0
    var wantMore: String? = null
    var more: Boolean = false


    do {
        //-----INPUTS-----
        print("Please enter the first monetary amount: ")
        do {
            monetaryAmount1 = readLine()
            decimalCounter = 0
            if (monetaryAmount1 == null || monetaryAmount1 == "") {
                validInput = false
                allCharAnalyzed = true
                println("You did not enter anything.")
                print("Please re-enter the first monetary amount: ")
            } else {
                for (index in monetaryAmount1.indices) {
                    var char = monetaryAmount1[index]
                    if (index == 0) {
                        if (char == '-') {
                            if (monetaryAmount1.length < 2) {
                                validInput = false
                            } else {
                                validInput = monetaryAmount1[1].isDigit()
                            }
                        } else {
                            validInput = char.isDigit()
                        }
                    } else {
                        if (validInput) {
                            if ((char == '.') && (decimalCounter == 0)) {
                                validInput = monetaryAmount1[index - 1].isDigit()
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
                    if (index == monetaryAmount1.length - 1 && validInput) {
                        allCharAnalyzed = true
                    }
                }
                if (!validInput) {
                    println("Your input was not a monetary value. ")
                    print("Please re-enter the first monetary amount: ")
                }
            }
        } while (!allCharAnalyzed || !validInput)
        validInput = false
        allCharAnalyzed = false
        decimalCounter = 0
        print("Please enter the second monetary amount: ")
        do {
            monetaryAmount2 = readLine()
            decimalCounter = 0
            if (monetaryAmount2 == null || monetaryAmount2 == "") {
                validInput = false
                allCharAnalyzed = true
                println("You did not enter anything.")
                print("Please re-enter the second monetary amount: ")
            } else {
                for (index in monetaryAmount2.indices) {
                    var char = monetaryAmount2[index]
                    if (index == 0) {
                        if (char == '-') {
                            if (monetaryAmount2.length < 2) {
                                validInput = false
                            } else {
                                validInput = monetaryAmount2[1].isDigit()
                            }
                        } else {
                            validInput = char.isDigit()
                        }
                    } else {
                        if (validInput) {
                            if ((char == '.') && (decimalCounter == 0)) {
                                validInput = monetaryAmount2[index - 1].isDigit()
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
                    if (index == monetaryAmount2.length - 1 && validInput) {
                        allCharAnalyzed = true
                    }
                }
                if (!validInput) {
                    println("Your input was not a monetary value. ")
                    print("Please re-enter the second monetary amount: ")
                }
            }
        } while (!allCharAnalyzed || !validInput)
        validInput = false
        allCharAnalyzed = false
        decimalCounter = 0
        print("Please enter the third monetary amount: ")
        do {
            monetaryAmount3 = readLine()
            decimalCounter = 0
            if (monetaryAmount3 == null || monetaryAmount3 == "") {
                validInput = false
                allCharAnalyzed = true
                println("You did not enter anything.")
                print("Please re-enter the third monetary amount: ")
            } else {
                for (index in monetaryAmount3.indices) {
                    var char = monetaryAmount3[index]
                    if (index == 0) {
                        if (char == '-') {
                            if (monetaryAmount3.length < 2) {
                                validInput = false
                            } else {
                                validInput = monetaryAmount3[1].isDigit()
                            }
                        } else {
                            validInput = char.isDigit()
                        }
                    } else {
                        if (validInput) {
                            if ((char == '.') && (decimalCounter == 0)) {
                                validInput = monetaryAmount3[index - 1].isDigit()
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
                    if (index == monetaryAmount3.length - 1 && validInput) {
                        allCharAnalyzed = true
                    }
                }
                if (!validInput) {
                    println("Your input was not a monetary value. ")
                    print("Please re-enter the third monetary amount: ")
                }
            }
        } while (!allCharAnalyzed || !validInput)
        validInput = false
        allCharAnalyzed = false
        decimalCounter = 0
        print("Please enter the fourth monetary amount: ")
        do {
            monetaryAmount4 = readLine()
            decimalCounter = 0
            if (monetaryAmount4 == null || monetaryAmount4 == "") {
                validInput = false
                allCharAnalyzed = true
                println("You did not enter anything.")
                print("Please re-enter the fourth monetary amount: ")
            } else {
                for (index in monetaryAmount4.indices) {
                    var char = monetaryAmount4[index]
                    if (index == 0) {
                        if (char == '-') {
                            if (monetaryAmount4.length < 2) {
                                validInput = false
                            } else {
                                validInput = monetaryAmount4[1].isDigit()
                            }
                        } else {
                            validInput = char.isDigit()
                        }
                    } else {
                        if (validInput) {
                            if ((char == '.') && (decimalCounter == 0)) {
                                validInput = monetaryAmount4[index - 1].isDigit()
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
                    if (index == monetaryAmount4.length - 1 && validInput) {
                        allCharAnalyzed = true
                    }
                }
                if (!validInput) {
                    println("Your input was not a monetary value. ")
                    print("Please re-enter the fourth monetary amount: ")
                }
            }
        } while (!allCharAnalyzed || !validInput)
        validInput = false
        allCharAnalyzed = false
        decimalCounter = 0
        print("Please enter the fifth monetary amount: ")
        do {
            monetaryAmount5 = readLine()
            decimalCounter = 0
            if (monetaryAmount5 == null || monetaryAmount5 == "") {
                validInput = false
                allCharAnalyzed = true
                println("You did not enter anything.")
                print("Please re-enter the fifth monetary amount: ")
            } else {
                for (index in monetaryAmount5.indices) {
                    var char = monetaryAmount5[index]
                    if (index == 0) {
                        if (char == '-') {
                            if (monetaryAmount5.length < 2) {
                                validInput = false
                            } else {
                                validInput = monetaryAmount5[1].isDigit()
                            }
                        } else {
                            validInput = char.isDigit()
                        }
                    } else {
                        if (validInput) {
                            if ((char == '.') && (decimalCounter == 0)) {
                                validInput = monetaryAmount5[index - 1].isDigit()
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
                    if (index == monetaryAmount5.length - 1 && validInput) {
                        allCharAnalyzed = true
                    }
                }
                if (!validInput) {
                    println("Your input was not a monetary value. ")
                    print("Please re-enter the fifth monetary amount: ")
                }
            }
        } while (!allCharAnalyzed || !validInput)
        validInput = false
        allCharAnalyzed = false
        print("Divide the value by how many? ")
        do {
            dividedByThis = readLine()
            if (dividedByThis == null || dividedByThis == "") {
                validInput = false
                allCharAnalyzed = true
                println("You did not enter anything.")
                print("Please re-enter the divisor: ")
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
                    println("Your input was not an integer. ")
                    print("Please re-enter the divisor (integer): ")
                }
            }
        } while (!allCharAnalyzed || !validInput)

        //-----OPERATION-----
        answer =
            (monetaryAmount1!!.toDouble() + monetaryAmount2!!.toDouble() + monetaryAmount3!!.toDouble() + monetaryAmount4!!.toDouble() + monetaryAmount5!!.toDouble()) / dividedByThis!!.toDouble()
        println("The answer is $answer.")
        println()
        print("Would you like to do another set? [Y/N] ")
        wantMore = readLine()
        if (wantMore == null || wantMore == "") {
            println("I'll take no response as a NO. B-bye!")
            more = false
        } else when(wantMore.lowercase()) {
            "y" -> {
                println("One more round!!!")
                println()
                more = true
            }
            "n" -> {
                println("Thank you for using this program!")
                more = false
            }
            else -> {
                println("Is this a test? Did I pass? :D I'm really tired, so I'm ending the program now.")
                more = false
            }
        }

    }while (more)
    println()
    println("Activity 01-D | Submitted by: Victor Yu Jr.")

//    SCRAPPING THIS AND USING STUFF LEARNED IN CLASS
//    //-----CHECK IF MONETARY AMOUNT AND DIVIDED BY INT-----
//    numericCheck1 = monetaryAmount1?.matches("-?\\d+(\\.\\d{2})?".toRegex())
//    numericCheck2 = monetaryAmount2?.matches("-?\\d+(\\.\\d{2})?".toRegex())
//    numericCheck3 = monetaryAmount3?.matches("-?\\d+(\\.\\d{2})?".toRegex())
//    numericCheck4 = monetaryAmount4?.matches("-?\\d+(\\.\\d{2})?".toRegex())
//    numericCheck5 = monetaryAmount5?.matches("-?\\d+(\\.\\d{2})?".toRegex())
//    intCheck = dividedByThis?.matches("-?\\d+".toRegex())
//
//    //-----ERROR HANDLING-----
//    if (monetaryAmount1 == null || monetaryAmount2 == null || monetaryAmount3 == null || monetaryAmount4 == null || monetaryAmount5 == null || dividedByThis == null || monetaryAmount1 == "" || monetaryAmount2 == "" || monetaryAmount3 == "" || monetaryAmount4 == "" || monetaryAmount5 == "" || dividedByThis == "") {
//        println("There was something missing in your input.")
//    } else if (numericCheck1 == true && numericCheck2 == true && numericCheck3 == true && numericCheck4 == true && numericCheck5 == true && intCheck == true) {
//        answer = (monetaryAmount1.toDouble() + monetaryAmount2.toDouble() + monetaryAmount3.toDouble() + monetaryAmount4.toDouble() + monetaryAmount5.toDouble()) / dividedByThis.toDouble()
//        println("The answer is $answer.")
//    } else println("Either not all inputs were numbers, or your numerical input was wrong.")

}