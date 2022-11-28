package activity_06a

import java.util.Date

open class Student(firstName: String, middleName: String, lastName: String):Person(firstName, middleName, lastName) {
    var yearEntered: Date = Date()
    var idNumber: String = ""
}

open class Person(firstName: String, middleName: String, lastName: String) {
    val firstName: String = firstName
    val middleName: String = middleName
    val lastName: String = lastName
    var address: String = ""
    var birthday: Date = Date()
}

class CertificateStudent(firstName: String, middleName: String, lastName: String, status: Status = Status.UNKNOWN):Student(firstName, middleName, lastName) {
    var shortCourses: ArrayList<String> = ArrayList()
}

class UnderGraduateStudent(firstName: String, middleName: String, lastName: String, status: Status = Status.UNKNOWN):Student(firstName, middleName, lastName), CollegeData {
    override var college: String = ""
        get() = field
        set(value) {
            field = value
        }
    override var collegeStart: Date = Date()
        get() = field
        set(value) {
            field = value
        }
    override var degrees: ArrayList<String> = ArrayList()
        get() = field
        set(value) {
            field = value
        }
    override var collegeEnd: Date? = null
        get() = field
        set(value) {
            field = value
        }
    override var statuses: ArrayList<Status> = ArrayList()
        get() = field
        set(value) {
            field = value
        }
}

interface CollegeData {
    var college: String
    var collegeStart: Date
    var degrees: ArrayList<String>
    var collegeEnd: Date?
    var statuses: ArrayList<Status>
}

interface MastersData {
    var college: String
    var collegeStart: Date
    var degree: String
    var collegeEnd: Date?
}

class MasterStudent(firstName: String, middleName: String, lastName: String, status: Status = Status.UNKNOWN):Student(firstName, middleName, lastName), MastersData {
    override var college: String = ""
        get() = field
        set(value) {
            field = value
        }
    override var collegeStart: Date = Date()
        get() = field
        set(value) {
            field = value
        }
    override var degree: String = ""
        get() = field
        set(value) {
            field = value
        }
    override var collegeEnd: Date? = null
        get() = field
        set(value) {
            field = value
        }

}

class GraduateStudent(firstName: String, middleName: String, lastName: String, status: Status = Status.UNKNOWN):Student(firstName, middleName, lastName) {
}

enum class Status {
    LEAVE_OF_ABSENCE,
    ONGOING,
    GRADUATED,
    WILL_BEGIN,
    UNKNOWN,
    SHIFTED
}

sealed class GradeExceptions {
    class InvalidInput(message: String = "Invalid Input"): Exception(message)
    class IncompleteGrades(message: String="Incomplete Grades"): Exception(message)
}

class Grades(firstName: String, middleName: String, lastName: String, status: Status = Status.UNKNOWN):Student(firstName, middleName, lastName) {
    fun getGrades(grades: Array<Double>) {
        if (grades.size > 10) {
            throw GradeExceptions.InvalidInput()
        } else if (grades.size < 10) {
            throw GradeExceptions.IncompleteGrades()
        } else {
            if(0.0 in grades) {
                throw GradeExceptions.IncompleteGrades()
            } else {
                println("Grade Input Successful")
            }
        }
    }
}

fun main() {
    var victorYu: Grades = Grades("Victor", "M", "Yu")
    val gradesList1 = arrayOf(10.0, 20.0, 30.0, 40.0, 50.0, 60.0, 70.0, 80.0, 90.0, 100.0)
    val gradesList2 = arrayOf(10.0, 20.0, 30.0, 40.0, 50.0, 60.0, 70.0, 80.0, 90.0, 100.0, 110.0)
    val gradesList3 = arrayOf(10.0, 20.0, 30.0, 40.0, 50.0, 60.0, 70.0, 80.0, 90.0)
    val gradesList4 = arrayOf(10.0, 20.0, 30.0, 40.0, 50.0, 60.0, 70.0, 80.0, 90.0, 0.0)

    try {
        victorYu.getGrades(gradesList1)
    }catch (e:GradeExceptions.InvalidInput) {
        e.printStackTrace()
    }catch (e:GradeExceptions.IncompleteGrades) {
        e.printStackTrace()
    }finally {
        try {
            victorYu.getGrades(gradesList2)
        }catch (e:GradeExceptions.InvalidInput) {
            e.printStackTrace()
        }catch (e:GradeExceptions.IncompleteGrades) {
            e.printStackTrace()
        }finally{
            try {
                victorYu.getGrades(gradesList3)
            }catch (e:GradeExceptions.InvalidInput) {
                e.printStackTrace()
            }catch (e:GradeExceptions.IncompleteGrades) {
                e.printStackTrace()
            }finally{
                try {
                    victorYu.getGrades(gradesList4)
                }catch (e:GradeExceptions.InvalidInput) {
                    e.printStackTrace()
                }catch (e:GradeExceptions.IncompleteGrades) {
                    e.printStackTrace()
                }
            }
        }
    }
}