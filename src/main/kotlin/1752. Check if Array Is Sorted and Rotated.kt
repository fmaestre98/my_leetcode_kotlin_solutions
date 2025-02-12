fun check(nums: IntArray): Boolean {
    val n = nums.size
    if (n == 1) return true
    val numsConcat = nums + nums
    var cont = 0
    for (i in 1 until n * 2) {
        if (numsConcat[i] >= numsConcat[i - 1]) {
            cont++
        } else {
            cont = 0
        }
        if (cont + 1 == n) return true
    }
    return false
}