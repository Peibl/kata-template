package action

import domain.GAME_STATUS
import infrastructure.InMemoryGames
import kotlin.test.assertEquals
import org.junit.Test


internal class PlayActionTest {
    @Test
    fun `Play X Mark`() {
        val inMemoryGames = InMemoryGames()
        val gameId = CreateGameAction(inMemoryGames).execute()

        val gameStatus = PlayAction(inMemoryGames).execute(gameId, POSITION_ONE)

        assertEquals(GAME_STATUS.PLAYER_O_TURN, gameStatus)
    }

    @Test
    fun `Play O Mark`() {
        val inMemoryGames = InMemoryGames()
        val gameId = CreateGameAction(inMemoryGames).execute()
        PlayAction(inMemoryGames).execute(gameId, POSITION_ONE)

        val gameStatus = PlayAction(inMemoryGames).execute(gameId, POSITION_TWO)

        assertEquals(GAME_STATUS.PLAYER_X_TURN, gameStatus)
    }

    private val POSITION_ONE = 1
    private val POSITION_TWO = 2
}