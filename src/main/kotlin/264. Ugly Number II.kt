import java.util.*
import kotlin.collections.HashSet

fun main() {
    println(nthUglyNumber(12))
}

fun nthUglyNumber(n: Int): Int {
    val ascendingQueue = PriorityQueue<Long>()
    val set = HashSet<Long>()
    ascendingQueue.add(1);
    set.add(1)
    var current = 1L
    for (i in 0 until n) {
        current = ascendingQueue.poll()

        if (set.add(current * 2)) {
          ascendingQueue.add(current * 2)
        }

        if (set.add(current * 3)) {
            ascendingQueue.add(current * 3)
        }

        if (set.add(current * 5)) {
            ascendingQueue.add(current * 5)
        }

    }


    return current.toInt()
}