package activity_05a

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