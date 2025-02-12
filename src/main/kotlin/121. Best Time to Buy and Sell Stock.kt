import kotlin.math.max

fun main() {
    println(maxProfit(intArrayOf(7,1,5,3,6,4)))
}

fun maxProfit(prices: IntArray): Int {
    val n = prices.size
    val array = IntArray(n) { 0 }
    var maxProfit = 0
    array[0] = prices[0]
    for (i in 1 until n) {
        if (prices[i] < array[i - 1]) {
            array[i] = prices[i]
        } else {
            array[i] = array[i-1]
            maxProfit = max(maxProfit, prices[i] - array[i - 1])
        }
    }
    return maxProfit
}


fun maxProfit2(prices: IntArray): Int {
    if (prices.isEmpty()) return 0

    var minPrice = prices[0]
    var maxProfit = 0

    for (price in prices) {
        if (price < minPrice) {
            minPrice = price
        } else {
            maxProfit = maxOf(maxProfit, price - minPrice)
        }
    }

    return maxProfit
}