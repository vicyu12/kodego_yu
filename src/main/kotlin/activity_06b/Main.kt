package activity_06b

fun main() {
    var victorYu: Borrower = Borrower("Victor", "Yu")
    victorYu.borrowerStatus = BorrowerStatus.GOOD_STANDING

    val jedMackay: Illustrator = Illustrator("Jed", "", "Mackay")
    val leeGarbett: Illustrator = Illustrator("Lee", "", "Garbett")
    val theDeathOfDrStrange: Comics = Comics("The Death of Doctor Strange", jedMackay, leeGarbett)
    theDeathOfDrStrange.bookStatus = BookStatus.FOR_INTERNAL_USE

    val aiWeiWei: Authors = Authors("Ai", "", "WeiWei")
    val aThousandYearsOfJoysAndSorrows: Books = Books("1000 Years of Joys and Sorrows", aiWeiWei)
    aThousandYearsOfJoysAndSorrows.bookStatus = BookStatus.RESERVED

    val meganNolan: Authors = Authors("Megan", "", "Nolan")
    val actsOfDesperation: Books = Books("Acts of Desperation", meganNolan)
    actsOfDesperation.bookStatus = BookStatus.FOR_REPAIR

    val anthonySo: Authors = Authors("Anthony", "Veasna", "So")
    val afterparties: Books = Books("Afterparties", anthonySo)
    afterparties.bookStatus = BookStatus.GOOD_TO_BORROW

    val nadiaOwusu: Authors = Authors("nadia","","Owusu")
    val aftershocks: Books = Books("Aftershocks", nadiaOwusu)
    aftershocks.bookStatus = BookStatus.GOOD_TO_BORROW

    val tiyaMiles: Authors = Authors("Tiya", "", "Miles")
    val allThatSheCarried: Books = Books("All That She Carried", tiyaMiles)
    allThatSheCarried.bookStatus = BookStatus.GOOD_TO_BORROW

    val rebeccaDonner: Authors = Authors("Rebecca", "", "Donner")
    val allTheFrequentTroublesOfOurDays: Books = Books("All The Frequent Troubles Of Our Days", rebeccaDonner)
    allTheFrequentTroublesOfOurDays.bookStatus = BookStatus.GOOD_TO_BORROW

    val sallyRooney: Authors = Authors("Sally", "", "Rooney")
    val beautifulWorldWhereAreYou: Books = Books("Beautiful World, Where are You", sallyRooney)
    beautifulWorldWhereAreYou.bookStatus = BookStatus.GOOD_TO_BORROW

    val ruthOzeki: Authors = Authors("Ruth", "", "Ozeki")
    val theBookOfFormAndEmptiness: Books = Books("The Book of Form and Emptiness", ruthOzeki)
    theBookOfFormAndEmptiness.bookStatus = BookStatus.GOOD_TO_BORROW

    val borrower: Borrowing = Borrowing(victorYu,theDeathOfDrStrange, aThousandYearsOfJoysAndSorrows, actsOfDesperation, afterparties, aftershocks, allThatSheCarried, allTheFrequentTroublesOfOurDays, beautifulWorldWhereAreYou, theBookOfFormAndEmptiness)
    victorYu.borrowerStatus = BorrowerStatus.UNPAID_DUES
    borrower.borrow()
    victorYu.borrowerStatus = BorrowerStatus.GOOD_STANDING
    borrower.borrow()
}