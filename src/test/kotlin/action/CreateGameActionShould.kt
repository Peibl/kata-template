package action

import domain.Game
import infrastructure.InMemoryGames
import org.junit.Test
import kotlin.test.assertEquals


internal class CreateGameActionShould {
    @Test
    fun `create new game`() {
        val inMemoryGames = InMemoryGames()

        val gameId = CreateGameAction(inMemoryGames).execute()

        assertEquals(inMemoryGames.getById(gameId), Game(gameId))
    }

}