fun divideArray1(nums: IntArray): Boolean {
    val map = mutableMapOf<Int, Int>()
    var oddsCount = 0

    for (i in nums) {
        map[i] = map.getOrDefault(i, 0) + 1
        if (map[i]!! % 2 != 0) {
            oddsCount++
        } else {
            oddsCount--
        }
    }
    return oddsCount == 0
}


fun divideArray(nums: IntArray): Boolean {
    return nums.groupBy { it }.values.all { it.size % 2 == 0 }
}