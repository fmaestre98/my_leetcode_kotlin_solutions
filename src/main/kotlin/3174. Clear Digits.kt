import java.util.*

fun main() {
    println(clearDigits("aebc12"))
}

fun clearDigits1(s: String): String {
    val stack = Stack<Char>()
    for (c in s) {
        if (c.isDigit()) {
            if (stack.isNotEmpty()) {
                stack.pop()
            }
        } else {
            stack.push(c)
        }
    }
    return stack.joinToString("")
}


fun clearDigits(s: String): String {
    val stack = mutableListOf<Char>()
    s.forEach { c ->
        if (c.isDigit()) {
            stack.removeLastOrNull()
        } else {
            stack.add(c)
        }
    }
    return buildString {
        stack.forEach { append(it) }
    }
}