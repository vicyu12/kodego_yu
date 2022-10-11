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

    var numericCheck1: Boolean? = null
    var numericCheck2: Boolean? = null
    var numericCheck3: Boolean? = null
    var numericCheck4: Boolean? = null
    var numericCheck5: Boolean? = null
    var intCheck: Boolean? = null

    //-----INPUTS-----
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

    //-----CHECK IF MONETARY AMOUNT AND DIVIDED BY INT-----
    numericCheck1 = monetaryAmount1?.matches("-?\\d+(\\.\\d{2})?".toRegex())
    numericCheck2 = monetaryAmount2?.matches("-?\\d+(\\.\\d{2})?".toRegex())
    numericCheck3 = monetaryAmount3?.matches("-?\\d+(\\.\\d{2})?".toRegex())
    numericCheck4 = monetaryAmount4?.matches("-?\\d+(\\.\\d{2})?".toRegex())
    numericCheck5 = monetaryAmount5?.matches("-?\\d+(\\.\\d{2})?".toRegex())
    intCheck = dividedByThis?.matches("-?\\d+".toRegex())

    //-----ERROR HANDLING-----
    if (monetaryAmount1 == null || monetaryAmount2 == null || monetaryAmount3 == null || monetaryAmount4 == null || monetaryAmount5 == null || dividedByThis == null || monetaryAmount1 == "" || monetaryAmount2 == "" || monetaryAmount3 == "" || monetaryAmount4 == "" || monetaryAmount5 == "" || dividedByThis == "") {
        println("There was something missing in your input.")
    } else if (numericCheck1 == true && numericCheck2 == true && numericCheck3 == true && numericCheck4 == true && numericCheck5 == true && intCheck == true) {
        answer = (monetaryAmount1.toDouble() + monetaryAmount2.toDouble() + monetaryAmount3.toDouble() + monetaryAmount4.toDouble() + monetaryAmount5.toDouble()) / dividedByThis.toDouble()
        println("The answer is $answer.")
    } else println("Either not all inputs were numbers, or your numerical input was wrong.")

}