import kotlin.math.min

fun main() {
    println(minimumCost("abcd", "acbe", charArrayOf('a'), charArrayOf('b'), intArrayOf(10000)))
    println(Int.MAX_VALUE)
}

fun floydWarshall(graph: Array<LongArray>): Array<LongArray> {
    val numVertices = graph.size
    val dist = Array(numVertices) { LongArray(numVertices) }

    // Inicializar la matriz de distancias.
    for (i in 0 until numVertices) {
        for (j in 0 until numVertices) {
            dist[i][j] = graph[i][j]
        }
    }

    // Implementación del algoritmo de Floyd-Warshall.
    for (k in 0 until numVertices) {
        for (i in 0 until numVertices) {
            for (j in 0 until numVertices) {
                if (dist[i][k] + dist[k][j] < dist[i][j]) {
                    dist[i][j] = dist[i][k] + dist[k][j]
                }
            }
        }
    }

    return dist
}

fun minimumCost(source: String, target: String, original: CharArray, changed: CharArray, cost: IntArray): Long {
    var res: Long = 0
    val map: HashMap<Char, Int> = HashMap()
    val uniqueChars = (original + changed).toSet().toCharArray()
    val n = uniqueChars.size
    val graph = Array(n) { LongArray(n) { Int.MAX_VALUE.toLong() } }
    for (i in 0 until n) {
        map[uniqueChars[i]] = i
    }

    for (i in original.indices) {
        if (original[i] == changed[i]) {
            graph[map[original[i]]!!][map[changed[i]]!!] = 0
        } else {
            graph[map[original[i]]!!][map[changed[i]]!!] =
                min(graph[map[original[i]]!!][map[changed[i]]!!], cost[i].toLong())
        }
    }
    val dist = floydWarshall(graph);
    for (i in source.indices) {
        if (source[i] == target[i]) continue
        if (!map.containsKey(source[i]) || !map.containsKey(target[i]) ||
            dist[map[source[i]]!!][map[target[i]]!!] >= Int.MAX_VALUE.toLong()
        ) {
            return -1
        }
        res += dist[map[source[i]]!!][map[target[i]]!!]
    }
    return res
}