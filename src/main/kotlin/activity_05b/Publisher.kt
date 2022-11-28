package activity_05b

import java.util.*
import kotlin.collections.ArrayList

class Books(title: String, author: Authors) {
    val title: String = title
    val author: Authors = author
    var yearPublished: Date = Date()
    var edition: String = ""
    var isbn: String = ""
    lateinit var publisher: Publisher
    val chaptersList: ArrayList<String> = ArrayList()
    var numberOfPages: Long = 0L
}

class Magazines(title: String, editor: Authors) {
    val title: String = title
    val editor: Authors = editor
    var monthPublished: Date = Date()
    var yearPublished: Date = Date()
    val articles: ArrayList<Article> = ArrayList()
}

class Newspaper(name: String) {
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

class Comics(title: String, vararg illustrators: Illustrator){
    val title: String = title
    val illustrators: ArrayList<Illustrator> = arrayListOf(*illustrators)
    lateinit var publisher: Publisher
    var monthPublished: Date = Date()
    var yearPublished: Date = Date()
}

//As with 04B, Illustrator inherited from Author. I believe they have the same function with just different mediums.

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

/*
*I will present different types of AV Materials using a class
* because there are other variables such as AV Material length,
* etc. That needs to be Instantiated. I could; however, use ENUM
*  for instantiating the type of AV.
 */

enum class AVTypes() {
    RECORDINGS,
    DOCUMENTARY,
    MOVIES,
    POWERPOINT,
    UNKNOWN
}

class AudioVideoRecording(title: String, publisher: String, avType: AVTypes = AVTypes.UNKNOWN) {
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

