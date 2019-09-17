package action

import domain.Game
import infrastructure.InMemoryGames


class CreateGameAction(val games: InMemoryGames) {

    fun execute(): Int {
        val game = Game();
        this.games.add(game)
        return game.id
    }
}