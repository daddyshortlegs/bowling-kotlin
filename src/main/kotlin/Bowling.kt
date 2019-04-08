class Bowling {
    fun convertInputToRolls(input: String): IntArray {
        val strippedInput = input.replace(" ", "")
        val arrayList = ArrayList<Int>()
        var i = 0;
        var previousChar = ' '
        for (char in strippedInput) {
            if (char == 'X' ) {
                arrayList.add(10);
            } else if (char == '/') {
                val parseInt = Integer.parseInt(previousChar.toString())
                arrayList.add(10 - parseInt)
            } else if (char == '-') {
                arrayList.add(0);
            } else {
                arrayList.add(Integer.parseInt(char.toString()))
            }
            previousChar = char
            i++
        }

        return arrayList.toIntArray()
    }

}
