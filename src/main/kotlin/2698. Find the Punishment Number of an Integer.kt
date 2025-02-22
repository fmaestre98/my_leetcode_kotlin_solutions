fun punishmentNumber(n: Int): Int {
    var result = 0
    for (i in 1..n) {
        if (canPartitionNumberOptimized(i * i, i)) {
            result += i * i
        }
    }
    return result
}

fun canPartitionNumberOptimized(number: Int, targetSum: Int, index: Int = 0, currentSum: Int = 0, memo: MutableMap<String, Boolean> = mutableMapOf()): Boolean {
    val key = "$index|$currentSum"
    if (memo.containsKey(key)) {
        return memo[key]!!
    }

    if (index == number.toString().length) {
        return currentSum == targetSum
    }

    var sum = 0
    for (i in index until number.toString().length) {
        sum = sum * 10 + (number.toString()[i] - '0')
        if (sum > targetSum) break

        if (canPartitionNumberOptimized(number, targetSum, i + 1, currentSum + sum, memo)) {
            memo[key] = true
            return true
        }
    }

    memo[key] = false
    return false
}