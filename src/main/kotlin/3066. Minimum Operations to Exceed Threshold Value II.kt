import java.util.*
import kotlin.math.max
import kotlin.math.min

fun main() {
    println(minOperations(intArrayOf(1000000000,999999999,1000000000,999999999,1000000000,999999999), 1000000000))
}
fun minOperations(nums: IntArray, k: Int): Int {
    var result = 0
    val ascendingQueue = PriorityQueue<Long>()

    nums.forEach {
        ascendingQueue.add(it.toLong())
    }

    while (ascendingQueue.peek() < k) {
        val x = ascendingQueue.poll()
        val y = ascendingQueue.poll()
        val newElement = if (x < y) x * 2 + y else y * 2 + x
        ascendingQueue.add(newElement)
        result++
    }

    return result
}