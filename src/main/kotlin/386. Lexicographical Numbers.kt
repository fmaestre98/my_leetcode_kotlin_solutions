fun main() {
    println(lexicalOrder(15))
}

    fun lexicalOrder(n: Int): List<Int> {
        val result = mutableListOf<Int>()

        fun dfs(current: Int) {
            if (current > n) return
            result.add(current)
            for (i in 0..9) {
                dfs(current * 10 + i)
            }
        }

        for (i in 1..9) {
            dfs(i)
        }

        return result
    }
