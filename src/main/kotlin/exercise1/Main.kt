package exercise1

fun main() {
    var positionApplication: String? = "VP of Engineering"
    var dateAvailable: String? = null
    var desiredSalary: Int? = 150_000
    var lastName: String? = "Yu"
    var firstName: String? = "Victor Jr"
    var middleName: String? = null
    var address: String? = "Blk3 Lot16 Camella Provence P9"
    var cityAddress: String? = "Plaridel"
    var stateAddress: String? = "Bulacan"
    var zipAdd: Int? = 3004
    var homePhone: String? = null
    var cellPhone: String? = "09178580469"
    var emailAdd: String? = "vicyu123@gmail.com"
    var socialSecurityNum: String? = "03-1234-5678-09"
    var usCitizen: Boolean? = false
    var felony: Boolean? = false
    var drugTest: Boolean? = null
    var schoolName1: String? = "De La Salle University - Manila"
    var schoolName2: String? = "Grace Christian High School"
    var schoolName3: String? = null
    var schoolLoc1: String? = "2401 Taft Ave"
    var schoolLoc2: String? = "Grace Avenue, Quezon City"
    var schoolLoc3: String? = null
    var yearAttended1: Int? = 2005
    var yearAttended2: Int? = 1945
    var yearAttended3: Int? = null
    var degreeReceived1: String? = "BS Mechanical Engineering"
    var degreeReceived2: String? = "High School"
    var degreeReceived3: String? = null
    var major1: String? = "Mechatronics"
    var major2: String? = null
    var major3: String? = null
    var otherLicenses: String? = "Registered Mechanical Engineer"
    var age: Int? = 17
    var birthDate: String? = null
    val validAge: IntRange = 18 .. 65
    val validYear: IntRange = 1950 .. 2022

    if (positionApplication==null) println("The field for Position you are applying for is not filled")
    if (dateAvailable==null) println("The field for Date Available is not filled")
    if (desiredSalary==null) println("The field for Desired Salary is not filled")
    if (lastName==null) println("The field for your Last Name is not filled")
    if (firstName==null) println("The field for your First Name is not filled")
    if (middleName==null) println("The field for your Middle Name is not filled")
    if (address==null) println("The field for your Street Address is not filled")
    if (cityAddress==null) println("The field for your City Address is not filled")
    if (stateAddress==null) println("The field for your State Address is not filled")
    if (zipAdd==null) println("The field for ZIP Address is not filled")
    if (homePhone==null) println("The field for your Home Phone Number is not filled")
    if (cellPhone==null) println("The field for your Cell Phone Number is not filled")
    if (emailAdd==null) println("The field for your E-Mail Address is not filled")
    if (socialSecurityNum==null) println("The field for your Social Security Number is not filled")
    if (usCitizen==null) println("The field asking if you are a US Citizen is not filled")
    if (felony==null) println("The field asking if you have committed a felony is not filled")
    if (drugTest==null) println("The field asking if you are willing to undergo drug testing is not filled")
    if (schoolName1==null) println("The field for your 1st School Attended is not filled")
    if (schoolLoc1==null) println("The field for your 1st School Location is not filled")
    if (yearAttended1 == null) println("The field for your year attended at your 1st school is not filled")
    else {
        if (yearAttended1 !in validYear) println("Invalid School Year for first school attended")
    }
    if (degreeReceived1==null) println("The field for your degree from your 1st school is not filled")
    if (major1==null) println("The field for your major from your 1st school is not filled")
    if (schoolName2==null) println("The field for your 2nd School Attended is not filled")
    if (schoolLoc2==null) println("The field for your 2nd School Location is not filled")
    if (yearAttended2 == null) println("The field for your year attended at your 2nd school is not filled")
    else {
        if (yearAttended2 !in validYear) println("Invalid School Year for second school attended")
    }
    if (degreeReceived2==null) println("The field for your degree from your 2nd school is not filled")
    if (major2==null) println("The field for your major from your 2nd school is not filled")
    if (schoolName3==null) println("The field for your 3rd School Attended is not filled")
    if (schoolLoc3==null) println("The field for your 3rd School Location is not filled")
    if (yearAttended3 == null) println("The field for your year attended at your 3rd school is not filled")
    else {
        if (yearAttended3 !in validYear) println("Invalid School Year for third school attended")
    }
    if (degreeReceived3==null) println("The field for your degree from your 3rd school is not filled")
    if (major3==null) println("The field for your major from your 3rd school is not filled")
    if (otherLicenses==null) println("The field asking for other licenses you might have is not filled")
    if (age==null) println("The field asking for your age is not filled")
    else {
        if (age !in validAge) println("Your age in not fit for the application")
    }
    if (birthDate==null) println("The field asking for your birth date is not filled.")

    /* println("-----------------------------------------------------------------------------------------")

        var x = 0
        val dataList = listOf(positionApplication, dateAvailable, desiredSalary, lastName, firstName, middleName, address, cityAddress, stateAddress, zipAdd, homePhone, cellPhone, emailAdd, socialSecurityNum, usCitizen, felony, drugTest, schoolName1, schoolLoc1, yearAttended1, degreeReceived1, major1, schoolName2, schoolLoc2, yearAttended2, degreeReceived2, major2, schoolName3, schoolLoc3, yearAttended3, degreeReceived3, major3, otherLicenses, age, birthDate)

        for (data in dataList) {
            if(data == null) {
                when (x) {
                    0 -> println("The field for Position you are applying for is not filled")
                    1 -> println("The field for Date Available is not filled")
                    2 -> println("The field for Desired Salary is not filled")
                    3 -> println("The field for your Last Name is not filled")
                    4 -> println("The field for your First Name is not filled")
                    5 -> println("The field for your Middle Name is not filled")
                    6 -> println("The field for your Street Address is not filled")
                    7 -> println("The field for your City Address is not filled")
                    8 -> println("The field for your State Address is not filled")
                    9 -> println("The field for ZIP Address is not filled")
                    10 -> println("The field for your Home Phone Number is not filled")
                    11 -> println("The field for your Cell Phone Number is not filled")
                    12 -> println("The field for your E-Mail Address is not filled")
                    13 -> println("The field for your Social Security Number is not filled")
                    14 -> println("The field asking if you are a US Citizen is not filled")
                    15 -> println("The field asking if you have committed a felony is not filled")
                    16 -> println("The field asking if you are willing to undergo drug testing is not filled")
                    17 -> println("The field for your 1st School Attended is not filled")
                    18 -> println("The field for your 1st School Location is not filled")
                    19 -> println("The field for your year attended at your 1st school is not filled")
                    20 -> println("The field for your degree from your 1st school is not filled")
                    21 -> println("The field for your major from your 1st school is not filled")
                    22 -> println("The field for your 2nd School Attended is not filled")
                    23 -> println("The field for your 2nd School Location is not filled")
                    24 -> println("The field for your year attended at your 2nd school is not filled")
                    25 -> println("The field for your degree from your 2nd school is not filled")
                    26 -> println("The field for your major from your 2nd school is not filled")
                    27 -> println("The field for your 3rd School Attended is not filled")
                    28 -> println("The field for your 3rd School Location is not filled")
                    29 -> println("The field for your year attended at your 3rd school is not filled")
                    30 -> println("The field for your degree from your 3rd school is not filled")
                    31 -> println("The field for your major from your 3rd school is not filled")
                    32 -> println("The field asking for other licenses you might have is not filled")
                    33 -> println("The field for your age is not filled.")
                    34 -> println("The field asking for your birth date is not filled.")
                }
            } else {
                if (data !in validYear) {
                    when (x) {
                        19 -> println("Invalid School Year for first school attended")
                        24 -> println("Invalid School Year for second school attended")
                        29 -> println("Invalid School Year for third school attended")
                    }
                }
                if (data !in validAge) {
                    when (x) {
                        33 -> println("Your age in not fit for the application")
                    }
                }
            }
            x += 1
        } */
}