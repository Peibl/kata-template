package domain

import java.util.*

class GameId() {
    private val value = UUID.randomUUID()

    companion object {
        fun generate(): GameId {
            return GameId()
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as GameId

        if (value != other.value) return false

        return true
    }

    override fun hashCode(): Int {
        return value?.hashCode() ?: 0
    }
}
