fun findThePrefixCommonArray(A: IntArray, B: IntArray): IntArray {
    var cont = 0
    val n = A.size
    val response = IntArray(n)
    val map = mutableMapOf<Int, Int>()
    for (i in 0 until n) {
        map[A[i]] = map.computeIfAbsent(A[i]) { 0 } + 1
        map[B[i]] = map.computeIfAbsent(B[i]) { 0 } + 1

        if (map[A[i]] == 2) {
            cont++
        }
        if (map[B[i]] == 2 && B[i] != A[i]) {
            cont++
        }
        response[i] = cont
    }
    return response
}