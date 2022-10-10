package codingbat

fun main() {
    var yourFashion: String? = null
    var dateFashion: String? = null
    val fashionRating: IntRange = 0 .. 10
    var gettingATable: Int = 0

    println("From 0 to 10 with 0 being bad and 10 being perfect,")
    print("How would you rate your fashion? ")
    yourFashion = readLine()
    print("How would you rate your date's fashion?")
    dateFashion = readLine()

    if (yourFashion==null||yourFashion==""||dateFashion==null||dateFashion=="") {
        println("You have missed some input/s")
    } else  if (yourFashion.all { Char -> Char.isDigit()} && dateFashion.all { Char -> Char.isDigit()}) {
        if (yourFashion.toInt() in fashionRating && dateFashion.toInt() in fashionRating) {
            if (yourFashion.toInt() <= 2 || dateFashion.toInt() <= 2) {
                gettingATable = 0
            } else if (yourFashion.toInt() >= 8 || dateFashion.toInt() >= 8) {
                gettingATable = 2
            } else gettingATable = 1
        } else println("Your input is outside the fashion range.")
    } else println("You did not input a number.")
    when (gettingATable) {
        0 -> println("Sorry but you won't get a table")
        1 -> println("Maybe you will get a table")
        2 -> println("You will be given a table")
    }
}