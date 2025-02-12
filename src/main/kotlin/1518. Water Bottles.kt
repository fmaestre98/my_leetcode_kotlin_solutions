import kotlin.system.measureTimeMillis

fun main() {
    val executionTime = measureTimeMillis {
        for (i in 1..900000) {
            numWaterBottles(i + 1000, 15)
        }
    }
    println(executionTime)
}

fun numWaterBottles(numBottles: Int, numExchange: Int): Int {
    return numBottles + (numBottles-1) / (numExchange - 1)
    /*var tempNumBottles = numBottles
    var res = numBottles

    while (tempNumBottles >= numExchange){
        res += tempNumBottles/numExchange
        tempNumBottles = (tempNumBottles/numExchange) + (tempNumBottles%numExchange)
    }
    return res*/
}