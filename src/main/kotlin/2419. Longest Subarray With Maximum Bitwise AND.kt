fun longestSubarray(nums: IntArray): Int {

    var max = 0
    var streak = 0
    var result = 0

    for (i in nums) {
        if (i > max) {
            max = i
            streak = 1
        } else if (i == max) {
            streak++
        } else {
            streak = 0
        }
        result = kotlin.math.max(result, streak)
    }

    return result
}


fun longestSubarray2(nums: IntArray): Int {

    val max = nums.maxOrNull() ?: return 0
    var maxStreak = 0
    var currentStreak = 0

    for (num in nums) {
        if (num == max) {
            currentStreak++
        } else {
            maxStreak = maxOf(maxStreak, currentStreak)
            currentStreak = 0
        }
    }

    // Verifica el streak final si termina con el máximo
    maxStreak = maxOf(maxStreak, currentStreak)

    return maxStreak
}