package infrastructure

import domain.Game

class InMemoryGames : Games {
    private var id = 1;
    private val games = mutableListOf<Game>()
    override fun findById(id: Int): Game {
        return this.games.filter { it.id == id }.single()
    }

    override fun add(game: Game) {
        game.id = this.id++
        this.games.add(game)
    }
}