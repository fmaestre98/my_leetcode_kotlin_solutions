fun main() {

}

fun construct2DArray(original: IntArray, m: Int, n: Int): Array<IntArray> {
    val size = original.size
    if (m * n != size) {
        return emptyArray<IntArray>()
    }
    val res = Array(m){IntArray(n)}
    var row: Int
    var col: Int
    for(i in 0 until size){
        row = i / n
        col = i % n
        res[row][col] = original[i]
    }
    return res
}