fun main() {
    println(
        removeOccurrences(
            "daabcbce",
            "abc"
        )
    )
}



fun removeOccurrences(s: String, part: String): String {
    val n = part.length
    val stack = mutableListOf<Char>()
    val partChars = part.toCharArray()

    for (c in s) {
        stack.add(c)
        if (stack.size >= n) {
            var match = true
            for (i in 0 until n) {
                if (stack[stack.size - n + i] != partChars[i]) {
                    match = false
                    break
                }
            }
            if (match) {
                repeat(n) { stack.removeAt(stack.size - 1) }
            }
        }
    }

    return buildString {
        stack.forEach { append(it) }
    }
}