package activity_05d

fun main() {
    val players: ArrayList<Player> = ArrayList()
    var winCondition: Boolean = false
    var board: Board = Board()
    var snakes: Snakes = Snakes()
    var ladders: Ladders = Ladders()

    var victor: Player = Player()
    victor.name = "Victor"
    victor.addPlayer(players)
    var jeca: Player = Player()
    jeca.name = "Jeca"
    jeca.addPlayer(players)
    var rinoa: Player = Player()
    rinoa.name = "Rinoa"
    rinoa.addPlayer(players)
    var aerith: Player = Player()
    aerith.name = "Aerith"
    aerith.addPlayer(players)
    var serah: Player = Player()
    serah.name = "Serah"
    serah.addPlayer(players)
    println("The players are:")
    players.forEach { println(it.name) }

    println()
    println("Let the game begin!")
    println()

    board.clearBoard()
    snakes.generateSnakesAndLadders(board)
    ladders.generateSnakesAndLadders(board)

    println()

    do {
        for (player in players) {
            players.forEach {
                winCondition = winCondition||it.finished
            }
            if (!winCondition) {
                player.move(board, player.rollDice())
            }
        }
    }while (!winCondition)
}