import java.lang.Math.max
import java.util.*

fun main(args: Array<String>) {
    println("Hello World!")
    println(longestSubarray(intArrayOf(24,12,71,33,5,87,10,11,3,58,2,97,97,36,32,35,15,80,24,45,38,9,22,21,33,68,22,85,35,83,92,38,59,90,42,64,61,15,4,40,50,44,54,25,34,14,33,94,66,27,78,56,3,29,3,51,19,5,93,21,58,91,65,87,55,70,29,81,89,67,58,29,68,84,4,51,87,74,42,85,81,55,8,95,39), 87))
    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
    println("Program arguments: ${args.joinToString()}")
}

fun longestSubarray(nums: IntArray, limit: Int): Int {
    var n = nums.size
    var left: Int = 0
    var right: Int = 0
    var diff = 0
    var maxDiff = 0;
    var res = 0
    var insert : Boolean = true
    // Priority queue en orden ascendente
    val ascendingQueue = PriorityQueue<Int>()

    // Priority queue en orden descendente
    val descendingQueue = PriorityQueue<Int>(compareByDescending { it })

    while (right in left until n) {
        if (insert){
            ascendingQueue.add(nums[right]);
            descendingQueue.add(nums[right]);
        }

        diff = descendingQueue.peek() - ascendingQueue.peek()

        if (diff <= limit) {
            right++
            res = max(res, right - left)
            insert = true
        } else {
            ascendingQueue.remove(nums[left])
            descendingQueue.remove(nums[left])
            left++
            insert = false
        }

    }

    return res
}