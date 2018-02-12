package bowling

class Game {
    var rolls = Array(21, { _ -> 0 })
    var currentRoll = 0

    fun roll(pins: Int) {
        rolls[currentRoll++] = pins
    }

    fun score(): Int {
        var score = 0
        var frameIndex = 0
        for (frame in 0..9) {
            if (isStrike(frameIndex)) {
                score += 10 + strikeBonus(frameIndex)
                frameIndex++
            } else if (isSpare(frameIndex)) {
                score += 10 + spareBonus(frameIndex)
                frameIndex += 2
            } else {
                score += sumOfBallsInFrame(frameIndex)
                frameIndex += 2
            }
        }
        return score
    }

    private fun sumOfBallsInFrame(frameIndex: Int) = rolls[frameIndex] + rolls[frameIndex + 1]

    private fun strikeBonus(frameIndex: Int) = rolls[frameIndex + 1] + rolls[frameIndex + 2]

    private fun spareBonus(frameIndex: Int) = rolls[frameIndex + 2]

    private fun isStrike(frameIndex: Int) = rolls[frameIndex] == 10

    private fun isSpare(frameIndex: Int) = rolls[frameIndex] + rolls[frameIndex + 1] == 10
}
