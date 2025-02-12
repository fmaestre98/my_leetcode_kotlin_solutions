import java.util.*

class NumberContainers() {
    val indexMap = mutableMapOf<Int, Int>()
    val numbersMap = mutableMapOf<Int, TreeSet<Int>>()
    fun change(index: Int, number: Int) {
        if (indexMap.containsKey(index) && numbersMap.containsKey(indexMap[index])) {
            numbersMap[indexMap[index]]!!.remove(index)
        }
        indexMap[index] = number
        if (!numbersMap.containsKey(number)) {
            numbersMap[number] = TreeSet<Int>()
        }
        numbersMap[number]!!.add(index)
    }

    fun find(number: Int): Int {
        return if (numbersMap.containsKey(number) && numbersMap[number]!!.isNotEmpty()) numbersMap[number]!!.first() else -1
    }

}

class NumberContainers2 {
    private val indexMap = mutableMapOf<Int, Int>()
    private val numbersMap = mutableMapOf<Int, TreeSet<Int>>()

    fun change(index: Int, number: Int) {
        // Remove the index from the current number's set
        indexMap[index]?.let { oldNumber ->
            numbersMap[oldNumber]?.remove(index)
        }
        // Update the index with the new number
        indexMap[index] = number
        // Add the index to the new number's set
        numbersMap.getOrPut(number) { TreeSet() }.add(index)
    }

    fun find(number: Int): Int {
        return numbersMap[number]?.firstOrNull() ?: -1
    }
}