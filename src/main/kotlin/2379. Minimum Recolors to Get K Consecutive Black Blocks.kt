import kotlin.math.min

fun main() {
    println(minimumRecolors("WBBWWBBWBW", 7))
}


fun minimumRecolors(blocks: String, k: Int): Int {
    var i = 0
    var j = k
    val n = blocks.length
    var whitesCount = 0
    var blacksCount = 0
    for (x in 0 until k) {
        if (blocks[x] == 'W') {
            whitesCount++
        } else {
            blacksCount++
        }
    }
    if (blacksCount >= k) {
        return 0
    }
    var response = k - blacksCount

    while (j < n) {
        if(blocks[i] == 'B'){
            blacksCount--
        } else {
            whitesCount--
        }
        if(blocks[j] == 'B'){
            blacksCount++
        } else {
            whitesCount++
        }

        if (blacksCount >= k) {
            return 0
        }
        response = min(response, k - blacksCount)
        j++
        i++
    }
    return response
}


fun minimumRecolors2(blocks: String, k: Int): Int {
    var whitesCount = blocks.take(k).count { it == 'W' }
    if (whitesCount == 0) return 0

    var minRecolors = whitesCount
    for (i in k until blocks.length) {
        if (blocks[i - k] == 'W') whitesCount--
        if (blocks[i] == 'W') whitesCount++
        minRecolors = minOf(minRecolors, whitesCount)
        if (minRecolors == 0) break
    }

    return minRecolors
}