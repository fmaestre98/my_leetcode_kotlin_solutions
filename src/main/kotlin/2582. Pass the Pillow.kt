fun main() {
    println(passThePillow(4, 5))
}

fun passThePillow(n: Int, time: Int): Int {
    if (n == time) {
        return n - 1
    }
    if (n > time) {
        return time + 1
    }
    val div: Int = time / (n - 1)
    val mod = time % (n - 1)

    return if (div % 2 == 0) {
        mod + 1
    } else {
        n - mod
    }

}