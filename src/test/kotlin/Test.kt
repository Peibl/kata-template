import action.CreateGameAction
import infrastructure.InMemoryGames
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test


class CreateGameActionShould {
    @Test
    fun `start with X turn`() {
        val inMemoryGames = InMemoryGames()
        val gameId = CreateGameAction(inMemoryGames).execute()

        val game = inMemoryGames.findById(gameId)
        assertThat(game.currentPlayer).isEqualTo("X")
    }

    @Test
    fun `create an empty Board`() {
        val inMemoryGames = InMemoryGames()
        val gameId = CreateGameAction(inMemoryGames).execute()

        val game = inMemoryGames.findById(gameId)
        assertThat(game.isBoardEmpty()).isTrue()
    }



}
