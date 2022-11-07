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
    logger.info { "Doing a Wild Search for: Rox, Xan, and Mike - using searchStudent Function:" }
    logger.info { "${searchStudent("Rox", "Xan", "Mike")}"}
    println()
    logger.info { "Doing a Search for: Merrill, Hector, Aella, Toma, Victor, Rox - using searchStudent Function:" }
    logger.info { "${searchStudent("Merrill", "Hector", "Aella", "Toma", "Victor", "Rox")}" }
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

fun searchStudentWildSearch(vararg searchNames: String): ArrayList<String> {
    var matchNames: ArrayList<String> = ArrayList()
    for (name in searchNames) {
        for (studentName in names) {
            if (name.lowercase() in studentName.lowercase()) {
                matchNames.add(studentName)
            }
        }
    }
    return matchNames
}

fun searchStudentName(vararg searchNames: String): ArrayList<String> {
    var matchNames: ArrayList<String> = ArrayList()
    for (name in searchNames) {
        if (name in names) {
            matchNames.add(name)
        }
    }
    return matchNames
}

fun searchStudent(vararg searchNames: String): ArrayList<String> {
    if (searchNames.size > 3) {
        return searchStudentName(*searchNames)
    }else {
        return searchStudentWildSearch(*searchNames)
    }
}

fun showStudents():Unit {
    for (name in names) {
        logger.info { name }
    }
}