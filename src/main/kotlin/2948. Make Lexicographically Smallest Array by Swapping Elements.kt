import java.util.LinkedList
import kotlin.math.abs

fun main() {
    lexicographicallySmallestArray(intArrayOf(1,60,34,84,62,56,39,76,49,38), 4).forEach {
        println(it)
    }
}

fun lexicographicallySmallestArray(nums: IntArray, limit: Int): IntArray {
    val n = nums.size
    val result = IntArray(n)
    val sorted = nums.sorted()
    val groupMap = HashMap<Int, Int>()
    val groupList = HashMap<Int, LinkedList<Int>>()
    var currentGroup = 0
    groupMap[sorted[0]] = 0
    groupList[0] = LinkedList<Int>()
    groupList[0]!!.add(sorted[0])

    for (i in 1 until n){
      if(abs(sorted[i] - sorted[i-1]) > limit){
          currentGroup++
      }
        groupMap[sorted[i]]=currentGroup

        if(!groupList.containsKey(currentGroup)){
            groupList[currentGroup] = LinkedList<Int>()
        }
        groupList[currentGroup]!!.add(sorted[i])
    }

    for (i in 0 until n){
        result[i] = groupList[groupMap[nums[i]]]!!.pop()
    }

    return result
}



fun lexicographicallySmallestArray2(nums: IntArray, limit: Int): IntArray {
    val n = nums.size
    val result = IntArray(n)

    val sorted = nums.sorted()
    val groupMap = mutableMapOf<Int, Int>()
    val groupList = mutableMapOf<Int, MutableList<Int>>()
    var currentGroup = 0

    groupMap[sorted[0]] = currentGroup
    groupList[currentGroup] = mutableListOf(sorted[0])

    for (i in 1 until n) {
        if (abs(sorted[i] - sorted[i - 1]) > limit) {
            currentGroup++
        }
        groupMap[sorted[i]] = currentGroup

        groupList.computeIfAbsent(currentGroup) { mutableListOf() }.add(sorted[i])
    }

    for (i in 0 until n) {
        result[i] = groupList[groupMap[nums[i]]]!!.removeAt(0)
    }

    return result
}