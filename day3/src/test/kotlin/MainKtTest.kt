import org.assertj.core.api.Assertions
import org.junit.Test

internal class MainKtTest {

    @Test
    fun powerConsumptionTest() {
        val numbers = """00100
            |11110
            |10110
            |10111
            |10101
            |01111
            |00111
            |11100
            |10000
            |11001
            |00010
            |01010""".trimMargin()
            .split("\n")
            .map { it.toCharArray() }
            .map { IntArray(it.size) { i -> it[i].digitToInt() } }

        Assertions.assertThat(powerConsumption(numbers))
            .isEqualTo(198)

    }

    @Test
    fun lifeSupportTest() {
        val numbers = """00100
            |11110
            |10110
            |10111
            |10101
            |01111
            |00111
            |11100
            |10000
            |11001
            |00010
            |01010""".trimMargin()
            .split("\n")
            .map { it.toCharArray() }
            .map { IntArray(it.size) { i -> it[i].digitToInt() } }

        Assertions.assertThat(oxGenRating(numbers) *
                co2ScrubberRating(numbers))
            .isEqualTo(230)

    }
}