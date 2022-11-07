package activity_03b


import mu.KotlinLogging
import kotlin.math.log

private val logger = KotlinLogging.logger {}

var bookNames: ArrayList<String> = ArrayList()

fun main() {
    bookNames.addAll(listOf("To Kill a Mockingbird", "1984", "Harry Potter and the Philosopher's Stone",
    "The Lord of the Rings", "The Great Gatsby", "Pride and Prejudice", "The Diary of a Young Girl",
    "The Book Thief", "The Hobbit", "Little Women", "Fahrenheit 451", "Jane Eyre", "Animal Farm", "Gone with the WInd",
    "The Caatcher in the Rye", "Charlotte's Web", "The Lion, the Witch, and the Wardrobe", "The Grapes of Wrath",
    "Lord of the Flies", "The Kite Runner"))

    logger.info { "Is 'Of Mice and Men' in the list? ${isBookInRecord("Of Mice and Men")}" }
    println()
    logger.info { "Adding 'Of Mice and Men' to the list:" }
    addBook("Of Mice and Men")
    showBooks()
    logger.info { "Count of books: ${countBooks()}" }
    println()
    logger.info { "Removing 'Of Mice and Men' from the list:" }
    removeBook("Of Mice and Men")
    showBooks()
    logger.info { "Count of books: ${countBooks()}" }
    println()
    logger.info { "Doing a Wild Search for: 'the'" }
    logger.info { "${searchBookWildSearch("the")}"}
    println()
    logger.info { "Doing a Search for: The Hobbit" }
    logger.info { "${searchBookName("The Hobbit")}" }
}

fun isBookInRecord (checkBookName: String): Boolean {
    return checkBookName in bookNames
}

fun addBook(addBookName: String): Unit {
    bookNames.add(addBookName)
}

fun removeBook(removeBookName: String): Unit {
    bookNames.remove(removeBookName)
}

fun countBooks(): Int {
    return bookNames.size
}

fun searchBookWildSearch(input: String): ArrayList<String> {
    var matchBookNames: ArrayList<String> = ArrayList()
        for (bookName in bookNames) {
            if (input.lowercase() in bookName.lowercase()) {
                matchBookNames.add(bookName)
            }
        }
    return matchBookNames
}

fun searchBookName(input: String): ArrayList<String> {
    var matchBookNames: ArrayList<String> = ArrayList()
        if (input in bookNames) {
            matchBookNames.add(input)
        }
    return matchBookNames
}

fun showBooks():Unit {
    for (bookName in bookNames) {
        logger.info { bookName }
    }
}