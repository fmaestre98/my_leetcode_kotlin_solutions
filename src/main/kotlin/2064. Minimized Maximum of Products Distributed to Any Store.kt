import kotlin.math.ceil


fun minimizedMaximum(n: Int, quantities: IntArray): Int {
    var left = 1  // Minimum possible x should start at 1
    var right = quantities.maxOrNull()!!  // Max quantity of any product
    // Since right is the max in quantities, it should be the maximum x we would need to consider.

    while (left < right) {
        val mid = (left + right) / 2

        if (isValidQuantity(n, quantities, mid)) {
            right = mid // We can try lower maximum
        } else {
            left = mid + 1 // We need a larger maximum
        }
    }
    return left
}

fun isValidQuantity(n: Int, quantities: IntArray, x: Int): Boolean {
    var storesNeeded = 0

    for (quantity in quantities) {
        storesNeeded += (quantity + x - 1) / x  // Equivalent to ceil(quantity / x)
        if (storesNeeded > n) return false  // If at any point we exceed n, we can stop
    }

    return storesNeeded <= n
}