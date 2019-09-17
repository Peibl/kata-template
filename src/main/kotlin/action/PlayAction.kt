package action

import infrastructure.InMemoryGames

class PlayAction(val inMemoryGames: InMemoryGames) {
    fun execute(gameId: Int, position: Int) {
        val game = this.inMemoryGames.findById(gameId)
        game.play(position);
    }
}