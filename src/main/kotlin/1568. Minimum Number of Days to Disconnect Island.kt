fun main() {
    val matrix = arrayOf(
        intArrayOf(0,0,0,0)
    )
    println(minDays(matrix))
}

fun minDays(grid: Array<IntArray>): Int {
    if (!isConnected(grid)) {
        return 0
    }

    var onesCount = 0

    // Count the number of 1s in the matrix
    for (i in grid.indices) {
        for (j in grid[0].indices) {
            if (grid[i][j] == 1) {
                onesCount++
            }
        }
    }

    // If there's only one 1, return 1 since it can be removed directly
    if (onesCount == 1) return 1
    if (onesCount == 0) return 0

    // Check the effect of removing each 1
    for (i in grid.indices) {
        for (j in grid[0].indices) {
            if (grid[i][j] == 1) {
                grid[i][j] = 0 // Remove the 1
                if (!isConnected(grid)) {
                    return 1 // If disconnected, one day is needed
                }
                grid[i][j] = 1 // Restore the 1
            }
        }
    }

    return 2 // If not disconnected by removing one 1, two days are needed
}

fun isConnected(grid: Array<IntArray>): Boolean {
    val visited = Array(grid.size) { BooleanArray(grid[0].size) }
    var found = false

    // Find the first 1 and start DFS from there
    for (i in grid.indices) {
        for (j in grid[i].indices) {
            if (grid[i][j] == 1) {
                dfs(grid, visited, i, j)
                found = true
                break
            }
        }
        if (found) break
    }

    // Check if there is any 1 that hasn't been visited
    for (i in grid.indices) {
        for (j in grid[i].indices) {
            if (grid[i][j] == 1 && !visited[i][j]) {
                return false
            }
        }
    }

    return true
}

fun dfs(matrix: Array<IntArray>, visited: Array<BooleanArray>, x: Int, y: Int) {
    // Check bounds and if the element has been visited
    if (x < 0 || x >= matrix.size || y < 0 || y >= matrix[0].size || visited[x][y] || matrix[x][y] == 0) {
        return
    }

    // Mark the node as visited
    visited[x][y] = true

    // Recursive calls in adjacent directions
    dfs(matrix, visited, x + 1, y)
    dfs(matrix, visited, x - 1, y)
    dfs(matrix, visited, x, y + 1)
    dfs(matrix, visited, x, y - 1)
}