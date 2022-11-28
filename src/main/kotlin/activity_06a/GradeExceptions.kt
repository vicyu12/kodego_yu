package activity_06a

sealed class GradeExceptions {
    class InvalidInput(message: String = "Invalid Input"): Exception(message)
    class IncompleteGrades(message: String="Incomplete Grades"): Exception(message)
}

class Grades {
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
    var grades: Grades = Grades()
    val gradesList1 = arrayOf(10.0, 20.0, 30.0, 40.0, 50.0, 60.0, 70.0, 80.0, 90.0, 100.0)
    val gradesList2 = arrayOf(10.0, 20.0, 30.0, 40.0, 50.0, 60.0, 70.0, 80.0, 90.0, 100.0, 110.0)
    val gradesList3 = arrayOf(10.0, 20.0, 30.0, 40.0, 50.0, 60.0, 70.0, 80.0, 90.0)
    val gradesList4 = arrayOf(10.0, 20.0, 30.0, 40.0, 50.0, 60.0, 70.0, 80.0, 90.0, 0.0)

    try {
        grades.getGrades(gradesList1)
    }catch (e:GradeExceptions.InvalidInput) {
        e.printStackTrace()
    }catch (e:GradeExceptions.IncompleteGrades) {
        e.printStackTrace()
    }finally {
        try {
            grades.getGrades(gradesList2)
        }catch (e:GradeExceptions.InvalidInput) {
            e.printStackTrace()
        }catch (e:GradeExceptions.IncompleteGrades) {
            e.printStackTrace()
        }finally{
            try {
                grades.getGrades(gradesList3)
            }catch (e:GradeExceptions.InvalidInput) {
                e.printStackTrace()
            }catch (e:GradeExceptions.IncompleteGrades) {
                e.printStackTrace()
            }finally{
                try {
                    grades.getGrades(gradesList4)
                }catch (e:GradeExceptions.InvalidInput) {
                    e.printStackTrace()
                }catch (e:GradeExceptions.IncompleteGrades) {
                    e.printStackTrace()
                }
            }
        }
    }
}