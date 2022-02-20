import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

internal class SubmarineTest {

    var submarine: Submarine = Submarine()

    @Before
    fun setUp() {
        submarine = Submarine()
    }

    @Test
    fun `when a forward command of x is executed then the horizontal position should be updated by +x`() {

        submarine.forward(10)
        assertEquals(10, submarine.horizontalPos)

    }

    @Test
    fun `when a down command of x is executed then the aim should be increased by x`() {
        submarine.down(10)
        assertEquals(10, submarine.aim)

    }

    @Test
    fun `when a up command of x is executed then the aim should be decreased by x`() {
        submarine.up(10)
        assertEquals(-10, submarine.aim)

    }

    @Test
    fun `when a forward command of x is executed then the horizontal position should be updated by +x and the depth by +(aim * x)`() {

        submarine.aim = 3

        submarine.forward(10)

        assertEquals(10, submarine.horizontalPos)
        assertEquals(30, submarine.depth)

    }

}