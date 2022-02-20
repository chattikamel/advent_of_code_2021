class Submarine(var depth: Int = 0, var horizontalPos: Int = 0, var aim: Int = 0) {
    fun down(x: Int) {
        aim += x
    }

    fun up(x: Int) {
        aim -= x
    }

    fun forward(x: Int) {
        horizontalPos += x
        depth += (x * aim)
    }

    fun process(commands: List<String>) {
        commands.forEach {
            val (command, value) = Regex("(\\w+) (\\d+)")
                .find(it)!!
                .destructured
            when (command) {
                "down" -> down(value.toInt())
                "up" -> up(value.toInt())
                "forward" -> forward(value.toInt())
            }
        }
    }
}
