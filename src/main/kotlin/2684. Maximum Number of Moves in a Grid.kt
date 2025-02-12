import kotlin.math.max

fun main() {
    val matrix = arrayOf(
        intArrayOf(137,112,78,67),
        intArrayOf(76,65,122,135),
    )
    println(maxMoves(matrix))
}

fun maxMoves(grid: Array<IntArray>): Int {
    val n = grid.size
    val m = grid[0].size
    val memo = Array(n) { IntArray(m) { -1 } }  // Usar -1 para indicar que no se ha visitado
    var response = 0
    for (i in 0 until n) {
        response = maxOf(response, dfsMaxMoves(grid, memo, i, 0))
    }
    return response
}

fun dfsMaxMoves(matrix: Array<IntArray>, memo: Array<IntArray>, x: Int, y: Int): Int {
    // Check bounds
    if (x < 0 || x >= matrix.size || y < 0 || y >= matrix[0].size) {
        return 0
    }

    // Check memoization
    if (memo[x][y] != -1) {
        return memo[x][y]
    }

    // Calculate the maximum moves from current position
    var maxSteps = 0

    if (x - 1 >= 0 && y + 1 < matrix[0].size && matrix[x - 1][y + 1] > matrix[x][y]) {
        maxSteps = maxOf(maxSteps, dfsMaxMoves(matrix, memo, x - 1, y + 1) + 1)
    }

    if (y + 1 < matrix[0].size && matrix[x][y + 1] > matrix[x][y]) {
        maxSteps = maxOf(maxSteps, dfsMaxMoves(matrix, memo, x, y + 1) + 1)
    }

    if (x + 1 < matrix.size && y + 1 < matrix[0].size && matrix[x + 1][y + 1] > matrix[x][y]) {
        maxSteps = maxOf(maxSteps, dfsMaxMoves(matrix, memo, x + 1, y + 1) + 1)
    }

    memo[x][y] = maxSteps
    return maxSteps
}