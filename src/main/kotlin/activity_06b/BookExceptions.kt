package activity_06b

import java.util.*
import kotlin.collections.ArrayList

open class LibraryItem {
    var bookStatus: BookStatus = BookStatus.GOOD_TO_BORROW
}

class Books(title: String, author: Authors): LibraryItem() {
    val title: String = title
    val author: Authors = author
    var yearPublished: Date = Date()
    var edition: String = ""
    var isbn: String = ""
    lateinit var publisher: Publisher
    val chaptersList: ArrayList<String> = ArrayList()
    var numberOfPages: Long = 0L
}

class Magazines(title: String, editor: Authors): LibraryItem() {
    val title: String = title
    val editor: Authors = editor
    var monthPublished: Date = Date()
    var yearPublished: Date = Date()
    val articles: ArrayList<Article> = ArrayList()
}

class Newspaper(name: String): LibraryItem() {
    val name: String = name
    var headline: String = ""
    var columnists: ArrayList<Authors> = ArrayList()
    var dayPublished: Date = Date()
    var monthPublished: Date = Date()
    var yearPublished: Date = Date()
    val articles: ArrayList<Article> = ArrayList()
}

open class Authors(firstName: String, middleName: String, lastName: String) {
    val firstName: String = firstName
    val middleName: String = middleName
    val lastName: String = lastName
    var dateOfBirth: Date = Date()
}

class Comics(title: String, vararg illustrators: Illustrator): LibraryItem(){
    val title: String = title
    val illustrators: ArrayList<Illustrator> = arrayListOf(*illustrators)
    lateinit var publisher: Publisher
    var monthPublished: Date = Date()
    var yearPublished: Date = Date()
}

class Illustrator(firstName: String, middleName: String, lastName: String): Authors(firstName, middleName, lastName) {
}

class Article(title: String, author: Authors) {
    val title: String = title
    val author: Authors = author
    var content: String = ""
}

class Search() {

    fun searchBookWildSearch(input: String, titleList: ArrayList<String>): ArrayList<String> {
        var matchBookNames: ArrayList<String> = ArrayList()
        for (bookName in titleList) {
            if (input.lowercase() in bookName.lowercase()) {
                matchBookNames.add(bookName)
            }
        }
        return matchBookNames
    }

    fun searchBookName(input: String, titleList: ArrayList<String>): ArrayList<String> {
        var matchBookNames: ArrayList<String> = ArrayList()
        if (input in titleList) {
            matchBookNames.add(input)
        }
        return matchBookNames
    }
    fun titleSearch(searchString: String, magazineList: ArrayList<Magazines>, newspaperList: ArrayList<Newspaper>, comicsList: ArrayList<Comics>): ArrayList<String> {
        var searchResults: ArrayList<String> = ArrayList()
        var searchFrom: ArrayList<String> = ArrayList()
        magazineList.forEach {
            searchFrom.add(it.title)
        }
        newspaperList.forEach {
            searchFrom.add(it.headline)
        }
        comicsList.forEach {
            searchFrom.add(it.title)
        }
        when(searchString.length) {
            0 -> {
                println("Cannot search for an empty String")
            }
            in 1 until 3 -> {
                searchResults = searchBookWildSearch(searchString, searchFrom)
            }
            else -> {
                searchResults = searchBookName(searchString, searchFrom)
            }
        }
        return searchResults
    }

    fun listOfWorks(author: Authors, magazineList: ArrayList<Magazines>, newspaperList: ArrayList<Newspaper>, comicsList: ArrayList<Comics>): ArrayList<String> {
        var works: ArrayList<String> = ArrayList()
        magazineList.forEach {
            if (author == it.editor) {
                works.add(it.title)
            }
        }
        newspaperList.forEach {
            it.columnists.forEach { itAuthor ->
                if (author == itAuthor) {
                    works.add(it.headline)
                }
            }
        }
        comicsList.forEach {
            it.illustrators.forEach { itIllustrator ->
                if (author == itIllustrator) {
                    works.add(it.title)
                }
            }
        }
        return works
    }
}

enum class AVTypes() {
    RECORDINGS,
    DOCUMENTARY,
    MOVIES,
    POWERPOINT,
    UNKNOWN
}

class AudioVideoRecording(title: String, publisher: String, avType: AVTypes = AVTypes.UNKNOWN): LibraryItem() {
    val avType: AVTypes = avType
    val title: String = title
    val publisher: String = publisher
    var lengthInHours: Double = 0.0
    var dateRecorded: Date = Date()
    var hasVideo: Boolean = false
    var hasAudio: Boolean = false
}

class Publisher(publisherName: String) {
    val publisherName: String = publisherName
    var address: String = ""
    var dateEST: Date = Date()

    fun publishMaterial(title: String, author: Authors) {

    }
    fun discontinueMaterial(title: String, author: Authors) {

    }
}

class Borrower(firstName: String, lastName: String) {
    val firstName: String = firstName
    val lastName: String = lastName
    var borrowList: ArrayList<LibraryItem> = ArrayList()
    var borrowerStatus: BorrowerStatus = BorrowerStatus.GOOD_STANDING
}

enum class BorrowerStatus {
    TOO_MANY_ITEMS_BORROWED,
    UNPAID_DUES,
    GOOD_STANDING
}

enum class BookStatus {
    GOOD_TO_BORROW,
    RESERVED,
    FOR_INTERNAL_USE,
    FOR_REPAIR
}

class Borrowing(borrower: Borrower, vararg libraryItem: LibraryItem) {
    val borrower: Borrower = borrower
    var libraryItems: ArrayList<LibraryItem> = arrayListOf(*libraryItem)
    private fun checkItemStatus() {
        libraryItems.forEach {
            try {
                when (it.bookStatus) {
                    BookStatus.GOOD_TO_BORROW -> borrower.borrowList.add(it)
                    BookStatus.RESERVED -> throw BookExceptions.BookStatusExceptions.ReservedBook()
                    BookStatus.FOR_INTERNAL_USE -> throw BookExceptions.BookStatusExceptions.ForInternalUse()
                    BookStatus.FOR_REPAIR -> throw BookExceptions.BookStatusExceptions.ForFixing()
                }
            }catch(e:BookExceptions.BookStatusExceptions.ReservedBook){
                e.printStackTrace()
            }catch(e:BookExceptions.BookStatusExceptions.ForInternalUse){
                e.printStackTrace()
            }catch(e:BookExceptions.BookStatusExceptions.ForFixing){
                e.printStackTrace()
            }finally {
                if (borrower.borrowList.size >= 5) {
                    borrower.borrowerStatus = BorrowerStatus.TOO_MANY_ITEMS_BORROWED
                    checkBorrowerStatus()
                }
            }
        }
    }
    private fun checkBorrowerStatus() {
        try {
            when(borrower.borrowerStatus) {
                BorrowerStatus.GOOD_STANDING -> checkItemStatus()
                BorrowerStatus.TOO_MANY_ITEMS_BORROWED -> throw BookExceptions.BorrowerExceptions.TooManyItemsBorrowed()
                BorrowerStatus.UNPAID_DUES -> throw BookExceptions.BorrowerExceptions.UnpaidDues()
            }
        }catch (e:BookExceptions.BorrowerExceptions.TooManyItemsBorrowed){
            e.printStackTrace()
        }catch (e:BookExceptions.BorrowerExceptions.UnpaidDues){
            e.printStackTrace()
        }
    }
    fun borrow() {
        checkBorrowerStatus()
    }
}

sealed class BookExceptions(message: String): Exception(message) {
    sealed class BorrowerExceptions(message: String): Exception(message) {
        class TooManyItemsBorrowed(message: String = "Cannot borrow due to too many items still borrowed."): Exception(message)
        class UnpaidDues(message: String = "Cannot borrow Exception due to unpaid dues."): Exception(message)
    }
    sealed class BookStatusExceptions(message: String): Exception(message) {
        class ReservedBook(message: String = "Cannot borrow due to reserved."): Exception(message)
        class ForInternalUse(message: String = "Cannot borrow due to item only used in library."): Exception(message)
        class ForFixing(message: String = "Cannot borrow due to item needs to be fixed."): Exception(message)
    }
}