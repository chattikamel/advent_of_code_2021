import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

internal class CommonSelectionTest {

    @Test
    fun mostCommon() {
        val numbers = intArrays()

        assertThat(mostCommon(0, numbers))
            .hasSameElementsAs(toIntArrays("""11110
                            |10110
                            |10111
                            |11100"""))


        assertThat(mostCommon(2, numbers))
            .hasSameElementsAs(toIntArrays("""00100
                            |11110
                            |10110
                            |10111
                            |01111
                            |11100"""))

    }


    @Test
    fun leastCommon() {
        val numbers = intArrays()

        assertThat(leastCommon(0, numbers))
            .hasSameElementsAs(toIntArrays("""00100
                            |01111
                            |01000
                            |00010"""))


        assertThat(leastCommon(2, numbers))
            .hasSameElementsAs(toIntArrays("""
                            |01000
                            |00010"""))

    }
    private fun intArrays() = toIntArrays(
        """00100
                            |11110
                            |10110
                            |10111
                            |01111
                            |01000
                            |11100
                            |00010"""
    )


    private fun toIntArrays(str: String) =
        str.trimMargin()
            .split("\n")
            .map(String::toIntArray)
}