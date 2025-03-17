fun main() {
    applyOperations(intArrayOf(1,1)).forEach {
        print(it)
        print(" ")
    }
}


fun applyOperations(nums: IntArray): IntArray {

    val stack = mutableListOf<Int>()
    var zeroCount = 0
    for (i in nums.indices) {
        if (nums[i] == 0) {
            zeroCount++
        } else {
            if (i + 1 < nums.size && nums[i] == nums[i + 1]) {
                stack.add(nums[i] * 2)
                nums[i + 1] = 0
            } else {
                stack.add(nums[i])
            }
        }
    }

    repeat(zeroCount){
        stack.add(0)
    }

    return stack.toIntArray()
}