package action

import domain.Game
import domain.GameId
import infrastructure.Games

class CreateGameAction(private var inMemoryGames: Games) {
    fun execute(): GameId {
        val gameId = inMemoryGames.nextId()
        val game = Game(gameId)
        inMemoryGames.add(game)
        return gameId
    }
}