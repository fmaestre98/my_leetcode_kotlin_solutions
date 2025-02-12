fun main() {
    println(countBadPairs(intArrayOf(1, 3)))
}
fun countBadPairs(nums: IntArray): Long {
    val map = mutableMapOf<Int, Long>()
    var goodPairsCount: Long = 0
    val n = nums.size.toLong()
    val totalPairs = n * (n - 1) / 2
    for (i in nums.indices) {
        val key = nums[i] - i
        goodPairsCount += map.getOrDefault(key, 0)
        map[key] = map.getOrDefault(key, 0) + 1
    }
    return totalPairs - goodPairsCount
}