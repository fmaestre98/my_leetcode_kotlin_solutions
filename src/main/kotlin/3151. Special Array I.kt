fun isArraySpecial(nums: IntArray): Boolean {
    var last = -1
    for (i in nums) {
        if (i % 2 == last) {
           return false
        }
        last = i % 2
    }
    return true
}


fun isArraySpecial2(nums: IntArray): Boolean {
    var previousParity: Int? = null
    for (num in nums) {
        val currentParity = num % 2
        if (currentParity == previousParity) {
            return false
        }
        previousParity = currentParity
    }
    return true
}