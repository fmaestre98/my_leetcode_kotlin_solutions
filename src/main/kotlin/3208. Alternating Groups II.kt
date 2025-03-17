fun main() {
    println(numberOfAlternatingGroups(intArrayOf(0, 1, 0), 3))
}

fun numberOfAlternatingGroups(colors: IntArray, k: Int): Int {
    var response = 0
    val n = colors.size
    if (k > n) return 0
    var prev = colors[0]
    var alterCount = 0
    for (i in 1 until n + k - 1) {
       if (colors[i%n] == prev){
           alterCount=1
           prev = colors[i%n]
           continue
       }
        alterCount++
        if (alterCount>=k){
            response++
        }
        prev = colors[i%n]
    }
    return response
}


fun numberOfAlternatingGroups2(colors: IntArray, k: Int): Int {
    val n = colors.size
    if (k < 2 || n < 2) return 0  // Grupos de tamaño <2 no son válidos

    // Paso 1: Crear array de transiciones
    val transitions = IntArray(n) { i ->
        if (colors[i] != colors[(i + 1) % n]) 1 else 0
    }

    // Paso 2: Extender el array para manejar circularidad
    val extendedTransitions = transitions + transitions

    // Paso 3: Calcular suma de prefijos
    val prefixSum = IntArray(extendedTransitions.size + 1)
    for (i in extendedTransitions.indices) {
        prefixSum[i + 1] = prefixSum[i] + extendedTransitions[i]
    }

    val windowSize = k - 1
    var count = 0

    // Paso 4: Contar ventanas válidas usando suma de prefijos
    for (i in 0 until n) {
        val end = i + windowSize
        if (end > extendedTransitions.size) break  // En casos donde k excede 2n
        if (prefixSum[end] - prefixSum[i] == windowSize) {
            count++
        }
    }

    return count
}