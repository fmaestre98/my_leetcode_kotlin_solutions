import java.time.LocalTime
import java.time.format.DateTimeFormatter
import kotlin.math.min

fun main() {
    println(findMinDifference(mutableListOf("00:00","04:00","22:00")))
}

fun findMinDifference(timePoints: List<String>): Int {
    val sorted = timePoints.sorted()
    var minDifference = Int.MAX_VALUE
    for (i in sorted.indices) {
        val time1 = sorted[i]
        val time2 = sorted[(i + 1) % sorted.size]
        minDifference = min(minDifference, calculateDifferenceInMinutes(time1, time2))
    }

    return minDifference
}

fun calculateDifferenceInMinutes(time1: String, time2: String): Int {
    val formatter = DateTimeFormatter.ofPattern("HH:mm")

    val localTime1 = LocalTime.parse(time1, formatter)
    val localTime2 = LocalTime.parse(time2, formatter)

    val differenceInMinutes = java.time.Duration.between(localTime1, localTime2).toMinutes().toInt()

    return if (differenceInMinutes < 0) {
        differenceInMinutes + 1440
    } else {
        differenceInMinutes
    }
}