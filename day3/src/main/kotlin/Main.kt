import kotlin.math.pow

fun main(strings: Array<String>) {
    val numbers = strings
        .map { it.toIntArray() }

    println("Power consumption (Gamma rate * epsilon rate) = ${powerConsumption(numbers)}")

    println(
        "Life support rating (Oxy generator rating * CO2 scrubber rating) = ${
            oxGenRating(numbers) *
                    co2ScrubberRating(numbers)
        }"
    )

}

fun powerConsumption(numbers: List<IntArray>): Int {
    val halfSize = numbers.size / 2
    val sumArray = numbers
        .reduce(IntArray::add)


    val gammaRate = sumArray.map { if (it > halfSize) 1 else 0 }
    val epRate = gammaRate.map { it.xor(1) }

    val fGammaRate = gammaRate.reversed().reduceIndexed(binaryToDec)
    val fEpRate = epRate.reversed().reduceIndexed(binaryToDec)

    return fEpRate * fGammaRate
}

val binaryToDec: (index: Int, acc: Int, Int) -> Int =
    { index, acc, v -> acc + (v * 2.0.pow(index)).toInt() }


private fun IntArray.toDecimal() = reversed().reduceIndexed(binaryToDec)

fun IntArray.add(elements: IntArray): IntArray {
    if (size == elements.size) {
        return IntArray(size) { i -> this[i] + elements[i] }
    }
    throw IllegalArgumentException("the two LongArrays must have the same size!! ")
}


fun String.toIntArray(): IntArray {
    val chars = toCharArray()
    return IntArray(chars.size) { i -> chars[i].digitToInt() }
}

fun leastCommon(index: Int, numbers: List<IntArray>): List<IntArray> {
    val map: Map<Int, List<IntArray>> = numbers.groupBy { it[index] }

    return if (map[0]!!.size > map[1]!!.size)
        map[1]!!
    else if (map[0]!!.size < map[1]!!.size)
        map[0]!!
    else map[0]!!
}

fun mostCommon(index: Int, numbers: List<IntArray>): List<IntArray> {
    val map: Map<Int, List<IntArray>> = numbers.groupBy { it[index] }

    return if (map[0]!!.size > map[1]!!.size)
        map[0]!!
    else if (map[0]!!.size < map[1]!!.size)
        map[1]!!
    else map[1]!!
}

fun co2ScrubberRating(numbers: List<IntArray>) = selection(numbers, ::leastCommon).toDecimal()

fun oxGenRating(numbers: List<IntArray>) = selection(numbers, ::mostCommon).toDecimal()


fun selection(numbers: List<IntArray>, selector: (Int, List<IntArray>) -> List<IntArray>): IntArray {
    var idx = 0
    var sub: List<IntArray> = selector(idx++, numbers)

    while (sub.size > 1)
        sub = selector(idx++, sub)

    return sub[0]
}


