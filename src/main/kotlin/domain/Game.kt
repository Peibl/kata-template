package domain

class Game(var id: Int = 0) {

    val board = mutableListOf<String>("", "", "", "", "", "", "", "", "")
    var currentPlayer = "X"
    fun isBoardEmpty(): Boolean {
        return true
    }

    fun play(position: Int) {
        this.board.set(position, currentPlayer)
        if (this.currentPlayer == "X") {
            this.currentPlayer = "O"
        } else {
            this.currentPlayer = "X"
        }
        this.verifyWin()
    }

    private fun verifyWin() {
        this.topHorizontally()
        this.middleHorizontally()
        this.bottomHorizontally()

    }

    private fun topHorizontally() {
        if (this.board.get(0).equals(this.board.get(1)) && this.board.get(0).equals(this.board.get(2))) {
            throw GameWinExpection()
        }
    }
    private fun middleHorizontally() {
        if (this.board.get(3).equals(this.board.get(4)) && this.board.get(3).equals(this.board.get(5))) {
            throw GameWinExpection()
        }
    }

    private fun bottomHorizontally() {
        if (this.board.get(6).equals(this.board.get(7)) && this.board.get(6).equals(this.board.get(7))) {
            throw GameWinExpection()
        }
    }
    fun getBoardPosition(i: Int): String {
        return this.board.get(i)

    }
}
