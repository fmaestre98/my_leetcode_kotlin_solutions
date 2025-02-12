import java.util.*

//[[1,2],[3,5],[2,2]]
fun main() {
    val matrix = arrayOf(
        intArrayOf(2,2),
        intArrayOf(1,2),
        intArrayOf(3,5)
    )
    println(maxAverageRatio(matrix, 2))
}

fun maxAverageRatio(classes: Array<IntArray>, extraStudents: Int): Double {
    var maxRatio: Double = 0.0

    val ascendingQueue = PriorityQueue<Pair<Double, Double>> { t, t2 -> ((t.first + 1) / (t.second + 1)).compareTo((t2.first + 1) / (t2.second + 1)) }

    for (i in classes) {
        ascendingQueue.add(Pair(i[0].toDouble(), i[1].toDouble()))
    }

    for (i in 0 until extraStudents) {
        val topPair = ascendingQueue.poll()
        val newPair = Pair(topPair.first + 1, topPair.second + 1)
        ascendingQueue.add(newPair)
    }
    while (ascendingQueue.isNotEmpty()) {
        val topPair = ascendingQueue.poll()
        maxRatio += (topPair.first / topPair.second )
    }

    return maxRatio/classes.size
}


