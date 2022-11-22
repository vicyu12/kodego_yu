package activity_04a

fun main() {
    val students: ArrayList<Student> = ArrayList()
    val wildSearch: StudentSearch = StudentSearch(students)
    var searchResult: HashSet<Student> = HashSet()

    val audrina: Student = Student("Audrina", "Chang", "22001", 2022)
    val mollie: Student = Student("Mollie", "Castillo", "22002", 2022)
    val avah: Student = Student("Avah", "Norman", "22003", 2022)
    val linda: Student = Student("Linda", "Robertson", "22004", 2022)
    val jabari: Student = Student("Jabari", "Acosta", "22005", 2022)
    val madilyn: Student = Student("Madilyn", "Brenan", "22006", 2022)
    val nia: Student = Student("Nia", "Summers", "22007", 2022)
    val alyvia: Student = Student("Alyvia", "Carroll", "22008", 2022)
    val colton: Student = Student("Colton", "Baired", "22009", 2022)
    val sonia: Student = Student("Sonia", "Richardson", "22010", 2022)
    val dahlia: Student = Student("Dahlia", "Villegas", "22011", 2022)
    val dalton: Student = Student("Dalton", "Morton", "22012", 2022)
    val lia: Student = Student("Lia", "Ellis", "22013", 2022)
    val trevon: Student = Student("Trevon", "Lutz", "22014", 2022)
    val bruno: Student = Student("Bruno", "Thornton", "22015", 2022)
    val isiah: Student = Student("Isiah", "Ortega", "22016", 2022)
    val bryant: Student = Student("Bryant", "Olson", "22017", 2022)
    val andres: Student = Student("Andres", "Mayo", "22018", 2022)
    val alice: Student = Student("Alice", "Yoder", "22019", 2022)
    val haley: Student = Student("Haley", "Curry", "22020", 2022)
    val arvin: Student = Student("Arvin", "Arf", "22021",2022)

    audrina.addStudent(students)
    mollie.addStudent(students)
    avah.addStudent(students)
    linda.addStudent(students)
    jabari.addStudent(students)
    madilyn.addStudent(students)
    nia.addStudent(students)
    alyvia.addStudent(students)
    colton.addStudent(students)
    sonia.addStudent(students)
    dahlia.addStudent(students)
    dalton.addStudent(students)
    lia.addStudent(students)
    trevon.addStudent(students)
    bruno.addStudent(students)
    isiah.addStudent(students)
    bryant.addStudent(students)
    andres.addStudent(students)
    alice.addStudent(students)
    haley.addStudent(students)
    arvin.addStudent(students)

    println("List of 21 students:")
    students.forEach { println("${it.lastName}, ${it.firstName}") }
    println("Wild Search for 'ar' results")
    searchResult = wildSearch.searchStudentWildSearch("ar")
    searchResult.forEach { println("${it.lastName}, ${it.firstName}") }
    println("Wild Search for 'ar' results in firstnames")
    searchResult = wildSearch.searchStudentWildSearch("ar", "firstname")
    searchResult.forEach { println("${it.lastName}, ${it.firstName}") }
    println("Wild Search for 'ar' results in lastnames")
    searchResult = wildSearch.searchStudentWildSearch("ar", "lastname")
    searchResult.forEach { println("${it.lastName}, ${it.firstName}") }
    println("Wild Search for 'ar' results in nicknames")
    searchResult = wildSearch.searchStudentWildSearch("ar","nickname")
    searchResult.forEach { println("${it.lastName}, ${it.firstName}") }
}

