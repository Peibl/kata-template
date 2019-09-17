package infrastructure

import domain.Game

interface Games {
    fun findById(id: Int): Game
    fun add(game: Game)
}