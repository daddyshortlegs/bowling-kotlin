import org.junit.Assert.assertArrayEquals
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class BowlingTest {

    private lateinit var bowling: Bowling

    @Before
    fun setup() {
        bowling = Bowling()
    }

    @Test
    fun convertInputToIntArray() {
        val expectedRolls = intArrayOf(1, 0, 5, 5, 3, 3, 10, 10, 3, 4, 0, 1, 3, 3, 2, 4, 2, 2)

        val actualRolls = bowling.convertInputToRolls("1- 5/ 33 X X 34 -1 33 24 22")

        assertArrayEquals(expectedRolls, actualRolls)
    }

    @Test
    fun gutterBall() {
        assertEquals(0, bowling.score("-- -- -- -- -- -- -- -- -- --"))
    }

    @Test
    fun allOnes() {
        assertEquals(10, bowling.score("1- 1- 1- 1- 1- 1- 1- 1- 1- 1-"))
    }

    @Test
    fun twoRolls() {
        assertEquals(4, bowling.score("22 -- -- -- -- -- -- -- -- --"))
    }

    @Test
    fun spare() {
        assertEquals(20, bowling.score("2/ 5- -- -- -- -- -- -- -- --"))
    }

}