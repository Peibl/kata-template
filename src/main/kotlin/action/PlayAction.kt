package action

import domain.GameId
import domain.GAME_STATUS
import domain.Position
import infrastructure.Games

class PlayAction(val games: Games) {
    fun execute(gameId: GameId, position: Int) : GAME_STATUS {
        val game = games.getById(gameId)
        return game.playInPosition(Position(position))
    }
}