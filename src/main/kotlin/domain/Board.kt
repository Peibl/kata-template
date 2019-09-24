package domain

class Board() {
    private val board = mutableMapOf<Position, Player>()
    init {
//        for (i in 1..9)  board[Position(i)] = Player(' ')
    }
    fun playTurn(position: Position, player: Player) {
        board[position] = player
    }
}
