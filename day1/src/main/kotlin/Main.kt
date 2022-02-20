
fun main(args: Array<String>) {
    println("Measuring depth increases ...")

    val intArgs = args.map(String::toInt).toTypedArray()


    val sonarSweep = SonarSweep(intArgs)
    println("there are ${sonarSweep.mesureIncreases()} measurements that are larger than the previous measurement")
    println("With 3 as a sliding window, there are ${sonarSweep.mesureIncreases(3)} measurements that are larger than the previous measurement")
}
