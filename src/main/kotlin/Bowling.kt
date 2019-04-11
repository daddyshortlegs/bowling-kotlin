class Bowling {

    fun score(s: String): Int {
        val rolls = convertInputToRolls(s)

        var score = 0
        var i = 0
        for (frames in 0 until 10) {
            if (isSpare(rolls, i)) {
                score += 10 + rolls[i + 2]
                i++
            } else {
                score += rolls[i] + rolls[i + 2]
            }
            i++
        }

        return score
    }

    private fun isSpare(rolls: IntArray, i: Int) = rolls[i] + rolls[i + 1] == 10


    fun convertInputToRolls(input: String): IntArray {
        val strippedInput = input.replace(" ", "")
        val arrayList = ArrayList<Int>()
        var i = 0
        var previousChar = ' '
        for (char in strippedInput) {
            if (char == 'X' ) {
                arrayList.add(10)
            } else if (char == '/') {
                arrayList.add(10 - convertCharToRoll(previousChar))
            } else if (char == '-') {
                arrayList.add(0)
            } else {
                arrayList.add(convertCharToRoll(char))
            }
            previousChar = char
            i++
        }

        return arrayList.toIntArray()
    }

    private fun convertCharToRoll(previousChar: Char) = Integer.parseInt(previousChar.toString())



}
