package activity_05d

open class Player() {
    var name: String = "Player"
    var finished: Boolean = false
        private set(value) {
            field = value
        }
    var position: Int = 0
        private set(value) {
            field = value
        }

    fun addPlayer(playerList: ArrayList<Player>) {
        playerList.add(this)
    }

    fun rollDice(): Int {
        val diceResult: Int = (1..6).random()
        println("Rolling the dice...")
        println("${this.name} rolled $diceResult!")
        return diceResult
    }

    fun move(board: Board, diceResult: Int) {
        position += diceResult
        if(position == board.boardSize-1) {
            finished = true
            println("${this.name} has won the game!")
        } else if (position >= board.boardSize) {
            position -= 2*(position - 99)
        } else if ("Snake Head" in board.boardLayout[position]) {
            for (block in 0 until board.boardSize) {
                if (board.boardLayout[block] == "Snake Tail #${board.boardLayout[position].takeLast(1)}") {
                    println("Oh, no! ${this.name} got bitten by a snake! Moving from $position to $block")
                    position = block
                }
            }
        } else if ("Ladder Ground" in board.boardLayout[position]) {
            for (block in 0 until board.boardSize) {
                if (board.boardLayout[block] == "Ladder Top #${board.boardLayout[position].takeLast(1)}") {
                    println("${this.name} is climbing up the ladder! Moving from $position to $block")
                    position = block
                }
            }
        }
        println("${this.name} is now positioned at block $position")
        println()
    }
}

class Board() {
    val boardSize: Int = 100
    val boardLayout: Array<String> = Array(boardSize){""}

    fun clearBoard() {
        for (block in boardLayout.indices) {
            boardLayout[block] = ""
        }
    }
}

interface SnakeAndLadders {
    fun generateSnakesAndLadders(board: Board)
}

class Snakes(): SnakeAndLadders {
    override fun generateSnakesAndLadders(board: Board) {
        val snakesGenerated: Int = board.boardSize/10
        var randomSnakeStart: Int = board.boardSize-1
        var randomSnakeEnd: Int = 1
        for (randomSnake in 1..snakesGenerated) {
            do {
                randomSnakeStart = (board.boardSize / 10 until board.boardSize).random()
                if (board.boardLayout[randomSnakeStart] == "") {
                    board.boardLayout[randomSnakeStart] = "Snake Head #$randomSnake"
                }
            }while (board.boardLayout[randomSnakeStart] != "Snake Head #$randomSnake")
            randomSnakeEnd = (1 until randomSnakeStart).random()
            board.boardLayout[randomSnakeEnd] = "Snake Tail #$randomSnake"
            println("Snake Head at $randomSnakeStart with tail at $randomSnakeEnd")
        }
    }
}

class Ladders(): SnakeAndLadders {
    override fun generateSnakesAndLadders(board: Board) {
        val laddersGenerated: Int = board.boardSize/10
        var randomLadderStart: Int = board.boardSize-1
        var randomLadderEnd: Int = 1
        for (randomLadder in 1..laddersGenerated) {
            do {
                randomLadderStart = (1 until board.boardSize).random()
                if (board.boardLayout[randomLadderStart] == "")
                    board.boardLayout[randomLadderStart] = "Ladder Ground #$randomLadder"
            }while (board.boardLayout[randomLadderStart] != "Ladder Ground #$randomLadder")
            randomLadderEnd = (randomLadderStart until board.boardSize).random()
            board.boardLayout[randomLadderEnd] = "Ladder Top #$randomLadder"
            println("Ladder Ground at $randomLadderStart with top at $randomLadderEnd")
        }
    }

}