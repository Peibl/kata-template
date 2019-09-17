package infrastructure

import domain.Game
import domain.GameId

interface Games {
    fun add(game: Game)
    fun getById(gameId: GameId): Game
    fun nextId(): GameId
}