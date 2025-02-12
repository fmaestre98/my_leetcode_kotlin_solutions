fun main() {

    //[[0,1],[0,2],[1,3],[1,4],[2,5],[2,6]]
    val matrix = arrayOf(
        intArrayOf(0,1),
        intArrayOf(0,2),
        intArrayOf(1,3),
        intArrayOf(1,4),
        intArrayOf(2,5),
        intArrayOf(2,6),
    )
    println(maxKDivisibleComponents(7, matrix, intArrayOf(1000000000,1000000000,1000000000,1000000000,1000000000,1000000000,1000000000), 7))
}


fun maxKDivisibleComponents(n: Int, edges: Array<IntArray>, values: IntArray, k: Int): Int {
    // Create a graph representation
    val graph = Array<MutableList<Int>>(n) { mutableListOf() }
    for (edge in edges) {
        graph[edge[0]].add(edge[1])
        graph[edge[1]].add(edge[0])
    }

    var components = 0

    // A DFS function that returns the sum of values in the subtree
    fun dfs(current: Int, parent: Int): Long {
        var subtreeSum: Long = values[current].toLong()

        for (neighbor in graph[current]) {
            if (neighbor != parent) {
                subtreeSum += dfs(neighbor, current)
            }
        }

        // Check if the current subtree sum is divisible by k
        if (subtreeSum % k == 0.toLong()) {
            components++ // We can count this component
            return 0 // Return 0 to indicate that this subtree can be split off
        }

        return subtreeSum // Return the sum to the parent
    }

    // Start DFS from the root node (0)
    dfs(0, -1)

    return components
}