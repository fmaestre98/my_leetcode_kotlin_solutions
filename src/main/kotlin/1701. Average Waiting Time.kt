import java.lang.Math.max

fun main() {

}

fun averageWaitingTime(customers: Array<IntArray>): Double {
    var total: Long = 0
    var prev = -1
    customers.forEach { customer ->
        prev = max(customer[0], prev) + customer[1]
        total += prev - customer[0]
    }
    val result = total.toDouble() / customers.size.toDouble()
    return String.format("%.5f", result).toDouble()
}