package action

import domain.GameWinExpection
import infrastructure.InMemoryGames
import org.junit.Test
import kotlin.test.assertEquals


internal class PlayActionTest {
    @Test
    fun `a character plays a X`() {
        val inMemoryGames = InMemoryGames()
        val gameId = CreateGameAction(inMemoryGames).execute()

        PlayAction(inMemoryGames).execute(gameId, 0)

        val game = inMemoryGames.findById(gameId)

        assertEquals(game.getBoardPosition(0), "X")
    }

    @Test
    fun `a character plays a O`() {
        val inMemoryGames = InMemoryGames()
        val gameId = CreateGameAction(inMemoryGames).execute()
        PlayAction(inMemoryGames).execute(gameId, 0)

        PlayAction(inMemoryGames).execute(gameId, 1)

        val game = inMemoryGames.findById(gameId)

        assertEquals(game.getBoardPosition(1), "O")
    }

    @Test(expected = GameWinExpection::class)
    fun `a X player wins in top horizontally`() {
        val inMemoryGames = InMemoryGames()
        val gameId = CreateGameAction(inMemoryGames).execute()
        PlayAction(inMemoryGames).execute(gameId, 0)
        PlayAction(inMemoryGames).execute(gameId, 3)
        PlayAction(inMemoryGames).execute(gameId, 1)
        PlayAction(inMemoryGames).execute(gameId, 4)

        PlayAction(inMemoryGames).execute(gameId, 2)
    }

    @Test(expected = GameWinExpection::class)
    fun `a O player wins in middle horizontally`() {
        val inMemoryGames = InMemoryGames()
        val gameId = CreateGameAction(inMemoryGames).execute()
        PlayAction(inMemoryGames).execute(gameId, 0)
        PlayAction(inMemoryGames).execute(gameId, 3)
        PlayAction(inMemoryGames).execute(gameId, 1)
        PlayAction(inMemoryGames).execute(gameId, 4)
        PlayAction(inMemoryGames).execute(gameId, 8)

        PlayAction(inMemoryGames).execute(gameId, 5)
    }
    @Test(expected = GameWinExpection::class)
    fun `a x player wins in bottom horizontally`() {
        val inMemoryGames = InMemoryGames()
        val gameId = CreateGameAction(inMemoryGames).execute()
        PlayAction(inMemoryGames).execute(gameId, 6)
        PlayAction(inMemoryGames).execute(gameId, 3)
        PlayAction(inMemoryGames).execute(gameId, 7)
        PlayAction(inMemoryGames).execute(gameId, 4)

        PlayAction(inMemoryGames).execute(gameId, 8)
    }
}