fun main() {
    println(minBitFlips(10, 7))
}
fun minBitFlips(start: Int, goal: Int): Int {
    var res = 0
    var binaryStart = start.toString(2)
    var binaryGoal = goal.toString(2)
    val zero = '0'

    if (binaryStart.length < binaryGoal.length){
        binaryStart = zero.toString().repeat(binaryGoal.length - binaryStart.length) + binaryStart
    } else if (binaryStart.length > binaryGoal.length){
        binaryGoal = zero.toString().repeat(binaryStart.length - binaryGoal.length) + binaryGoal
    }

    for (i in 0 until binaryGoal.length){
        if (binaryStart[i] != binaryGoal[i]){
            res++
        }
    }

    return res
}

fun minBitFlips2(start: Int, goal: Int): Int {
    // Perform an XOR operation to find the differing bits
    val differentBits = start xor goal
    // Initialize a counter for the number of differing bits
    var count = 0
    var temp = differentBits

    // Count the number of '1's in the differingBits
    while (temp > 0) {
        count += temp and 1 // Check the least significant bit
        temp = temp shr 1   // Shift the bits to the right
    }

    return count // Return the total count of differing bits
}