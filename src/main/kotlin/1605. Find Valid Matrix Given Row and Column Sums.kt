import java.lang.Integer.min

fun main() {

}

fun restoreMatrix(rowSum: IntArray, colSum: IntArray): Array<IntArray> {
    val N = rowSum.size
    val M = colSum.size
    val res = Array(N) { IntArray(M) }
    val accRow = IntArray(N)
    val accCol = IntArray(M)
    for (i in 0 until N) {
        for (j in 0 until M) {
            res[i][j] = min(rowSum[i] - accRow[i], colSum[j] - accCol[j])
            accRow[i] += res[i][j]
            accCol[j] += res[i][j]
        }
    }
    return res
}