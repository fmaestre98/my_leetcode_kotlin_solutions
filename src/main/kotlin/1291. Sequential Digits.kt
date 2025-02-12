import java.lang.Math.max
import java.util.*

fun main(args: Array<String>) {
    println("Hello World!")
    println(sequentialDigits(1000, 13000))
    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
    println("Program arguments: ${args.joinToString()}")
}

fun sequentialDigits(low: Int, high: Int): List<Int> {
    val sequentialDigits = mutableListOf<Int>();

    fun helper(start: Int, low: Int, high: Int) {
        if (start in low..high) {
            sequentialDigits.add(start)
        } else if (start > high) {
            return
        }
        val cad: StringBuilder = StringBuilder(start.toString())
        if (cad.last() == '9') {
            return
        }
        cad.append((cad.last().toString().toInt() + 1).toString())
        helper(cad.toString().toInt(), low, high)
    }

    for (i in 1..9) {
        helper(i, low, high)
    }
    sequentialDigits.sort()
    return sequentialDigits;
}


