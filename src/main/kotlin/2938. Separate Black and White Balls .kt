fun main() {
    println(minimumSteps("11110000"))
}

fun minimumSteps(s: String): Long {
    val n = s.length
    var whiteCount = 0
    var minSteps: Long = 0
    for (c in s) {
        if (c == '0') whiteCount++
    }
    if (whiteCount == n || whiteCount == 0) return 0

    var currentSteps = 0
    for (c in s) {
        if (c == '1') {
            currentSteps ++
        } else {
            minSteps += currentSteps
        }

    }

    return minSteps
}