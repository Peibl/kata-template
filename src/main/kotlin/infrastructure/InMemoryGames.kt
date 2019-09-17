package infrastructure

import domain.Game
import domain.GameId

class InMemoryGames : Games {


    val games = mutableListOf<Game>()
    override fun add(game: Game) {
        games.add(game)

    }

    override fun getById(gameId: GameId): Game {
        return games.find { it == Game(gameId) }!!
    }

    override fun nextId(): GameId {
        return GameId.generate()
    }


}