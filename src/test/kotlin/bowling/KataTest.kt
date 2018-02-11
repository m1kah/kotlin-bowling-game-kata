package bowling

import org.junit.Test

class KataTest {
    var game = Game()

    @Test
    fun testGame() {
        println("score: " + game.score())
    }
}
