package domain

class Game(private var id: GameId) {
    private var currentTurn = Player('X')
    private val board = Board()

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Game

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }

    fun playInPosition(position: Position) : GAME_STATUS {
        board.playTurn(position, currentTurn)
        return GAME_STATUS.PLAYER_O_TURN
    }
}
