import org.junit.Assert.assertArrayEquals
import org.junit.Before
import org.junit.Test

class BowlingTest {

    private lateinit var bowling: Bowling

    @Before
    fun setup() {
        bowling = Bowling();
    }

    @Test
    fun convertInputToIntArray() {
        val expectedRolls = intArrayOf(1, 0, 5, 5, 3, 3, 10, 10, 3, 4, 0, 1, 3, 3, 2, 4, 2, 2)

        val actualRolls = bowling.convertInputToRolls("1- 5/ 33 X X 34 -1 33 24 22")

        assertArrayEquals(expectedRolls, actualRolls)
    }

}