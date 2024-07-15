case class Book(title:String, author:String, isbn:String)

@main def main():Unit = {
    var library: Set[Book]= Set(
        Book("Madol Duwa", "Martin Wickramasinghe", "1"),
        Book("Gampaleriya", "Martin Wickramasinghe", "2"),
        Book("Hath Pana", "Kumaratunga Munidasa", "3"),
        Book("Kaliyugaya", "Martin Wickramasinghe", "4")

    )
    library= addBook(library)
    println("Remove Book")
    library = removeBook(library, "1")
    println("Check Book")
    checkBook(library, "1")
    checkBook(library, "2")
    println("Print Library")
    printLibrary(library)
    println("Search Book")
    searchBook(library, "Hath Pana")
    println("Author Books")
    authorBooks(library, "Martin Wickramasinghe")

}

def addBook(library:Set[Book]): Set[Book] = 
    print("Book Title: ")
    val title = scala.io.StdIn.readLine()
    print("Book Author: ")
    val author = scala.io.StdIn.readLine()
    print("Book ISBN: ")
    val isbn = scala.io.StdIn.readLine()
    library + Book(title, author, isbn)


def removeBook(library:Set[Book], isbn:String): Set[Book] =
    val bookToDelete = library.find(_.isbn == isbn)
    bookToDelete match {
        case None => library
        case _ => library - bookToDelete.head
    }
    

def checkBook(library:Set[Book], isbn:String): Unit = 
    library match {
        case a if a.isEmpty => println(s"$isbn Not found")
        case a if a.head.isbn == isbn => println(s"$isbn Found")
        case _ => checkBook(library.tail, isbn)
    }

def printLibrary(library:Set[Book]): Unit = 
    library match {
        case a if a.isEmpty =>
        case _ =>{
            printf("%s | %s | %s\n",library.head.title,library.head.author, library.head.isbn)
            printLibrary(library.tail)}
    }

def searchBook(library:Set[Book], title:String): Unit =
    library match {
        case a if a.isEmpty => println("Not found")
        case a if a.head.title == title => printf("%s | %s | %s\n",library.head.title,library.head.author, library.head.isbn)
        case _ => searchBook(library.tail, title)
    }

def authorBooks(library:Set[Book], author:String): Unit = 
    library match {
        case a if a.isEmpty =>
        case a if a.head.author == author => {
            printf("%s | %s | %s\n",library.head.title,library.head.author, library.head.isbn)
            authorBooks(library.tail, author)
        }
        case _ => authorBooks(library.tail, author)
    }