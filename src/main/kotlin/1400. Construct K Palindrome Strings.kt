fun canConstruct(s: String, k: Int): Boolean {

    if (s.length < k) return false

    val map = mutableMapOf<Char, Int>()
    for (c in s) {
        map[c] = map.computeIfAbsent(c) { 0 } + 1
    }
    val oddsCount = map.count { it.value % 2 != 0 }

    return oddsCount <= k
}