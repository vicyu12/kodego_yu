package activity_01i

import mu.KotlinLogging

private val logger = KotlinLogging.logger {}

fun main() {
    var bookList = ArrayList<String>()
    var bookISBNList = ArrayList<String>()
    var bookAuthorList = ArrayList<String>()
    var bookPublisherList = ArrayList<String>()
    var bookAvailabilityList = ArrayList<Boolean>()
    var book: String? = null
    var isbn: String? = null
    var bookAuthor: String? = null
    var bookPublisher: String? = null
    var willBorrow: String? = null
    var whoBorrowList = ArrayList<String>()
    var untilWhenBorrowList = ArrayList<Int>()
    var borrower: String? = null
    var borrowDays: Int? = null
    var more: String? = null
    var close: Boolean = false

    do {
        logger.info { "Kindly input the following information of the book to be borrowed:" }
        logger.info { "Book Title:" }
        book = readLine()
        logger.info { "ISBN #:" }
        isbn = readLine()
        logger.info { "Book Author/s:" }
        bookAuthor = readLine()
        logger.info { "Book Publisher:" }
        bookPublisher = readLine()
        if (bookList.isEmpty()) {
            bookList.add(book.toString())
            bookISBNList.add(isbn.toString())
            bookAuthorList.add(bookAuthor.toString())
            bookPublisherList.add(bookPublisher.toString())
            bookAvailabilityList.add(true)
            whoBorrowList.add("")
            untilWhenBorrowList.add(0)
        } else {
            if (book !in bookList || isbn !in bookISBNList || bookAuthor !in bookAuthorList || bookPublisher !in bookPublisherList) {
                bookList.add(book.toString())
                bookISBNList.add(isbn.toString())
                bookAuthorList.add(bookAuthor.toString())
                bookPublisherList.add(bookPublisher.toString())
                bookAvailabilityList.add(true)
                whoBorrowList.add("")
                untilWhenBorrowList.add(0)
            } else {
                for (index in bookList.indices) {
                    if (book == bookList[index] || isbn == bookISBNList[index] || bookAuthor == bookAuthorList[index] || bookPublisher == bookPublisherList[index]) {

                    } else  {
                        bookList.add(book.toString())
                        bookISBNList.add(isbn.toString())
                        bookAuthorList.add(bookAuthor.toString())
                        bookPublisherList.add(bookPublisher.toString())
                        bookAvailabilityList.add(true)
                        whoBorrowList.add("")
                        untilWhenBorrowList.add(0)
                    }
                }
            }
        }
        for (index in bookList.indices) {
            if (book == bookList[index] || isbn == bookISBNList[index] || bookAuthor == bookAuthorList[index] || bookPublisher == bookPublisherList[index]) {
                if (bookAvailabilityList[index]) {
                    logger.info { "This book is available. Will the person like to proceed with borrowing this book? [Y/N]" }
                    willBorrow = readLine()
                    when (willBorrow?.uppercase()) {
                        "Y" -> {
                            logger.info { "Who is borrowing this book?" }
                            borrower= readLine()
                            whoBorrowList[index] = borrower.toString()
                            logger.info { "How long will the book be borrowed for?" }
                            borrowDays= readLine()?.toIntOrNull()
                            if (borrowDays == null) {
                                borrowDays = 14
                            }
                            untilWhenBorrowList[index] = borrowDays
                            bookAvailabilityList[index] = false
                        }
                        else -> {
                            logger.info { "Oh, Okay." }
                        }
                    }
                } else {
                    logger.info { "This book has been borrowed by ${whoBorrowList[index]} for ${untilWhenBorrowList[index]} days" }
                }
            }
        }
        println()
        logger.info { "Would you like to terminate this program? [Y/N]" }
        more = readLine()
        when (more?.uppercase()) {
            "N" -> close = false
            else -> close = true
        }
    }while(!close)
}