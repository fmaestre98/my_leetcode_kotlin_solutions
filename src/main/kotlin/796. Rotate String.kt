fun main() {
    println(rotateString("abcde","cdeab"))
}


fun rotateString(s: String, goal: String): Boolean {

    if (s == goal) {
        return true
    }

    val stringBuilder = StringBuilder(s)
    var char = '-'
    for (i in 0 until s.length) {
        char = stringBuilder.takeLast(1)[0]
        stringBuilder.deleteCharAt(stringBuilder.lastIndex)
        stringBuilder.insert(0, char)
        if (stringBuilder.toString() == goal) {
            return true
        }
    }

    return false;
}


fun rotateString2(s: String, goal: String): Boolean {
    if (s.length != goal.length) {
        return false
    }

    val doubledS = s + s

    return doubledS.contains(goal)
}