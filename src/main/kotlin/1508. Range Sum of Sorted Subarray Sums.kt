fun main() {

}

fun rangeSum(nums: IntArray, n: Int, left: Int, right: Int): Int {

    val newArrayLength = n * (n+1)/2
    val newArray: IntArray = IntArray(newArrayLength)
    var count = 0
    for (i in 0 until n){
        for (j in i until n){
            newArray[count] = if (i == j) nums[i] else newArray[count-1]+nums[j]
            count++
        }
    }
    newArray.sort()
    var response = 0
    for (i in left until right+1){
        response = (response + newArray[i-1]) % 1000000007
    }

    return response
}