import kotlin.math.max

fun maximumSum(nums: IntArray): Int {
    val map = mutableMapOf<Int, Int>()
    var response = -1
    for (it in nums) {
        val digitSum = it.digitSum()
        if (map.containsKey(digitSum)) {
            response = max(response, it + map.getOrDefault(digitSum, 0))
            map[digitSum] = max(it, map.getOrDefault(digitSum, 0))
        } else {
            map[digitSum] = it
        }
    }

    return response
}

private fun Int.digitSum(): Int {
    var sum = 0
    var num = this
    while (num != 0) {
        sum += num % 10
        num /= 10
    }
    return sum
}