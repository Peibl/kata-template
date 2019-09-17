import org.assertj.core.api.Assertions.assertThat
import org.junit.Test


class TestShould {
    @Test
    fun `fail`() {
        assertThat(1).isEqualTo(2)
    }

}
