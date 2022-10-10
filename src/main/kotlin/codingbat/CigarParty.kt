package codingbat

fun main() {
    val lowerBound: Int = 40
    val upperBoundWeekday: Int = 60
    var isItWeekend: String? = null
    var cigarNumber: String? = ""

    print("Is it the weekend? ")
    isItWeekend = readLine()
    print("How many cigars are there? ")
    cigarNumber = readLine()

    if (isItWeekend.equals(null) || cigarNumber.equals(null) || isItWeekend.equals("") || cigarNumber.equals("")) {
        println("Your inputs are incomplete.")
    } else {
        if (cigarNumber?.all { Char -> Char.isDigit()} == true) {
            when(isItWeekend?.lowercase()) {
                "y" -> if (cigarNumber?.toInt()!! >= lowerBound) {
                    println("Squirrel party is successful!")
                } else println("Squirrel party is not successful :(")
                "yes" -> if (cigarNumber?.toInt()!! >= lowerBound) {
                    println("Squirrel party is successful!")
                } else println("Squirrel party is not successful :(")
                "yeah" -> if (cigarNumber?.toInt()!! >= lowerBound) {
                    println("Squirrel party is successful!")
                } else println("Squirrel party is not successful :(")
                "yea" -> if (cigarNumber?.toInt()!! >= lowerBound) {
                    println("Squirrel party is successful!")
                } else println("Squirrel party is not successful :(")
                "ya" -> if (cigarNumber?.toInt()!! >= lowerBound) {
                    println("Squirrel party is successful!")
                } else println("Squirrel party is not successful :(")
                "yah" -> if (cigarNumber?.toInt()!! >= lowerBound) {
                    println("Squirrel party is successful!")
                } else println("Squirrel party is not successful :(")
                "n" -> if (cigarNumber?.toInt()!! in lowerBound .. upperBoundWeekday) {
                    println("Squirrel party is successful!")
                } else println("Squirrel party is not successful :(")
                "no" -> if (cigarNumber?.toInt()!! in lowerBound .. upperBoundWeekday) {
                    println("Squirrel party is successful!")
                } else println("Squirrel party is not successful :(")
                else -> println("I don't think you answered the questions correctly")

            }
        } else println("The number of cigar inputted was not a number.")

    }

}