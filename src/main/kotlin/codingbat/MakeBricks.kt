package codingbat

fun main() {
    var smallBricksAmount: String? = null
    var bigBricksAmount: String? = null
    var goalBrickLength: String? = null
    var bricksToFillBySmall: Int = 0
    var bricksToFillByBig: Int = 0

    print("How many small bricks (1 inch) are there: ")
    smallBricksAmount = readLine()
    print("How many big bricks (5 inches) are there: ")
    bigBricksAmount = readLine()
    print("What is the goal length you want to build: ")
    goalBrickLength = readLine()

    if (smallBricksAmount == null || smallBricksAmount == "" || bigBricksAmount == null || bigBricksAmount == "" || goalBrickLength == null || goalBrickLength == "") {
        println("You gave incomplete data to solve the problem.")
    } else if (smallBricksAmount.all {Char -> Char.isDigit()} && bigBricksAmount.all {Char -> Char.isDigit()} && goalBrickLength.all {Char -> Char.isDigit()}) {
        bricksToFillByBig = goalBrickLength.toInt() / 5
        if (bricksToFillByBig > bigBricksAmount.toInt()) bricksToFillByBig = bigBricksAmount.toInt()
        bricksToFillBySmall = goalBrickLength.toInt() - bricksToFillByBig*5
        if (bricksToFillBySmall > smallBricksAmount.toInt()) println("The goal cannot be met.")
        else println("The goal can be met.")
    } else println("Your inputs were not all numbers.")

}