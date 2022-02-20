

class SonarSweep(private val depths: Array<Int>) {


    fun mesureIncreases(window: Int = 1) =
        if (window == 1) _mesureIncreases(depths)
        else _mesureIncreases(arrangeDepths(window))

    private fun _mesureIncreases(depths: Array<Int>): Int {
        return depths.foldIndexed(0)
        { index, acc, depth ->
            var newAcc: Int = acc
            if (index == 0)
                newAcc = 0
            else if (depths[index - 1] < depth)
                newAcc++

            newAcc
        }
    }


    private fun arrangeDepths(window: Int): Array<Int> {
        val range = 0 until window

        val slidingArray = Array(depths.size - (window - 1))
        { index ->
            range.sumOf { depths[index + it] }
        }
        return slidingArray
    }
}








