import org.junit.Assert.assertEquals
import org.junit.Test

internal class SonarSweepTest {

    @Test
    fun `zero increase for no depth`() {
        val sonarSweep = SonarSweep(arrayOf())

        assertEquals(0, sonarSweep.mesureIncreases())

    }

    @Test
    fun `zero increase for one depth`() {
        val sonarSweep = SonarSweep(arrayOf(199))

        assertEquals(0, sonarSweep.mesureIncreases())

    }


    @Test
    fun `1 increase for for depths(199, 200)`() {
        val sonarSweep = SonarSweep(arrayOf(199, 200))

        assertEquals(1, sonarSweep.mesureIncreases())

    }

    @Test
    fun `0 increase for for depths(199, 180)`() {
        val sonarSweep = SonarSweep(arrayOf(199, 180))

        assertEquals(0, sonarSweep.mesureIncreases())

    }


    @Test
    fun `7 increases for example 1`() {
        val sonarSweep = SonarSweep(arrayOf(199, 200, 208, 210, 200, 207, 240, 269, 260, 263))

        assertEquals(7, sonarSweep.mesureIncreases())

    }

    @Test
    fun `5 increases for example 1 with a window of 3`() {
        val sonarSweep = SonarSweep(arrayOf(199, 200, 208, 210, 200, 207, 240, 269, 260, 263))

        assertEquals(5, sonarSweep.mesureIncreases(3))

    }


}