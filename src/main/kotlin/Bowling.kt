class Bowling {

    fun score(s: String): Int {
        val rolls = convertInputToRolls(s)
        return calulcate(rolls)
    }

    fun convertInputToRolls(input: String): IntArray {
        val arrayList = ArrayList<Int>()
        var i = 0
        var previousChar = ' '
        for (char in removeSpacesFrom(input)) {
            convertCharToRollValue(char, arrayList, previousChar)
            previousChar = char
            i++
        }

        return arrayList.toIntArray()
    }

    private fun removeSpacesFrom(input: String) = input.replace(" ", "")

    private fun convertCharToRollValue(char: Char, arrayList: ArrayList<Int>, previousChar: Char) {
        if (char == 'X') {
            arrayList.add(10)
        } else if (char == '/') {
            arrayList.add(10 - convertCharToRoll(previousChar))
        } else if (char == '-') {
            arrayList.add(0)
        } else {
            arrayList.add(convertCharToRoll(char))
        }
    }

    private fun convertCharToRoll(previousChar: Char) = Integer.parseInt(previousChar.toString())

    private fun calulcate(rolls: IntArray): Int {
        var score = 0
        var i = 0
        for (frames in 0 until 10) {
            if (isSpare(rolls, i)) {
                score += calculateSpare(rolls, i)
                i++
            } else if (isStrike(rolls, i)) {
                score += calculateStrike(rolls, i)
            } else {
                score += calculateFrame(rolls, i)
            }
            i++
        }
        return score
    }

    private fun isSpare(rolls: IntArray, i: Int) = rolls[i] + rolls[i + 1] == 10

    private fun calculateSpare(rolls: IntArray, i: Int) = 10 + rolls[i + 2]

    private fun isStrike(rolls: IntArray, i: Int) = rolls[i] == 10

    private fun calculateStrike(rolls: IntArray, i: Int) = 10 + rolls[i + 1] + rolls[i + 2]

    private fun calculateFrame(rolls: IntArray, i: Int) = rolls[i] + rolls[i + 2]

}
