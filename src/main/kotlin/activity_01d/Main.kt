package activity_01d

fun main() {
    println("You will need to enter 5 monetary amounts that will be added together.")
    println("The sum of the 5 amounts you entered will then be divided by an integer you will input.")
    println()

    var monetaryAmount1: String? = null
    var monetaryAmount2: String? = null
    var monetaryAmount3: String? = null
    var monetaryAmount4: String? = null
    var monetaryAmount5: String? = null
    var dividedByThis: String? = null
    var answer: Int? = null

    print("Please enter the first monetary amount: ")
    monetaryAmount1 = readLine()
    print("Please enter the second monetary amount: ")
    monetaryAmount2 = readLine()
    print("Please enter the third monetary amount: ")
    monetaryAmount3 = readLine()
    print("Please enter the fourth monetary amount: ")
    monetaryAmount4 = readLine()
    print("Please enter the fifth monetary amount: ")
    monetaryAmount5 = readLine()

    print("Divide the value by how many? ")
    dividedByThis = readLine()

    if (monetaryAmount1 == null || monetaryAmount2 == null || monetaryAmount3 == null || monetaryAmount4 == null || monetaryAmount5 == null || dividedByThis == null || monetaryAmount1 == "" || monetaryAmount2 == "" || monetaryAmount3 == "" || monetaryAmount4 == "" || monetaryAmount5 == "" || dividedByThis == "") {
        println("There was something missing in your input.")
    } else if (monetaryAmount1.all {Char -> Char.isDigit()} && monetaryAmount2.all {Char -> Char.isDigit()} && monetaryAmount3.all {Char -> Char.isDigit()} && monetaryAmount4.all {Char -> Char.isDigit()} && monetaryAmount5.all {Char -> Char.isDigit()} && dividedByThis.all {Char -> Char.isDigit()}) {
        answer = (monetaryAmount1.toInt() + monetaryAmount2.toInt() + monetaryAmount3.toInt() + monetaryAmount4.toInt() + monetaryAmount5.toInt()) / dividedByThis.toInt()
        println("The answer is $answer.")
    } else println("Not all inputs were numbers.")

}