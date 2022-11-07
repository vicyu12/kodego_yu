package activity_03a

import mu.KotlinLogging
import kotlin.math.log

private val logger = KotlinLogging.logger {}

var names: ArrayList<String> = ArrayList()

fun main() {
    names.addAll(listOf("Roxanne", "Asgeirr", "Aella", "Hector", "Xanthe", "Tiarnach", "Merrill", "Toma", "Annalena", "McKinley", "Leesa", "Baila", "Radhika", "Lilly","Tierney", "Morana", "Hughard", "Ami", "Jordan", "Hirsh"))

    logger.info { "Is Victor in the list? ${isStudentInRecord("Victor")}" }
    println()
    logger.info { "Adding Victor to the list:" }
    addStudent("Victor")
    showStudents()
    logger.info { "Count of students: ${countStudent()}" }
    println()
    logger.info { "Removing Victor from the list:" }
    removeStudent("Victor")
    showStudents()
    logger.info { "Count of students: ${countStudent()}" }
    println()
    logger.info { "Doing a Wild Search for: An - using searchStudent Function:" }
    logger.info { "${searchStudent("An")}"}
    println()
    logger.info { "Doing a Search for: Merrill" }
    logger.info { "${searchStudent("Merrill")}" }
}

fun isStudentInRecord (checkName: String): Boolean {
    return checkName in names
}

fun addStudent(addName: String): Unit {
    names.add(addName)
}

fun removeStudent(removeName: String): Unit {
    names.remove(removeName)
}

fun countStudent(): Int {
    return names.size
}

fun searchStudentWildSearch(searchName: String): ArrayList<String> {
    var matchNames: ArrayList<String> = ArrayList()
        for (studentName in names) {
            if (searchName.lowercase() in studentName.lowercase()) {
                matchNames.add(studentName)
            }
        }
    return matchNames
}

fun searchStudentName(searchName: String): ArrayList<String> {
    var matchNames: ArrayList<String> = ArrayList()
        if (searchName in names) {
            matchNames.add(searchName)
        }
    return matchNames
}

fun searchStudent(searchName: String): ArrayList<String> {
    if (searchName.length > 3) {
        return searchStudentName(searchName)
    }else {
        return searchStudentWildSearch(searchName)
    }
}

fun showStudents():Unit {
    for (name in names) {
        logger.info { name }
    }
}