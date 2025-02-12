fun main() {

}

fun canBeEqual(target: IntArray, arr: IntArray): Boolean {

    val map = HashMap<Int, Int>()
    for (i in target) {
        map[i] = map.getOrDefault(i, 0) + 1
    }

    for (i in arr) {
        if (!map.containsKey(i) || (map.containsKey(i) && map[i] == 0)) return false
        map[i] = map[i]!! - 1
    }

    return true
}