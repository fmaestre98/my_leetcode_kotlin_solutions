import kotlin.math.max

fun main() {
    println(longestMonotonicSubarray(intArrayOf(1,4,3,3,2)))
}

fun longestMonotonicSubarray(nums: IntArray): Int {
    if (nums.isEmpty()) return 0

    var maxLength = 1
    var maxLengthDecreasing = 1
    var maxLengthIncreasing = 1


    for (i in 1 until nums.size) {
         if(nums[i] > nums[i-1]){
             maxLengthIncreasing++
         } else {
             maxLengthIncreasing = 1
         }

        if(nums[i] < nums[i-1]){
            maxLengthDecreasing++
        } else {
            maxLengthDecreasing = 1
        }
        maxLength = max(maxLength, max(maxLengthDecreasing, maxLengthIncreasing))
    }

    return maxLength
}