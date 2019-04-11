class Bowling {

    fun score(s: String): Int {
        val rolls = convertInputToRolls(s)

        var score = 0
        for (roll in rolls) {
            score += roll
        }

        return score
    }


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
