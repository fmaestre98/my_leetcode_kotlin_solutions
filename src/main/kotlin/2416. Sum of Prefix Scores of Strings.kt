fun main() {
    val result = sumPrefixScores(arrayOf("abc","ab","bc","b"))
    for (r in result){
        println(r)
    }

}

fun sumPrefixScores(words: Array<String>): IntArray {
    val n = words.size
    val response = IntArray(n)
    val trie = Trie()

    for (index in words.indices) {
        trie.insert(words[index])
    }

    for (index in words.indices) {
        response[index] = trie.calculatePrefixScore(words[index])
    }

    return response
}

class TrieNode {
    val children: MutableMap<Char, TrieNode> = mutableMapOf()
    var isEndOfWord: Boolean = false
    var wordCount: Int = 0
}

class Trie {
    private val root: TrieNode = TrieNode()

    fun insert(word: String) {
        var currentNode = root
        for (char in word) {
            currentNode = currentNode.children.computeIfAbsent(char) { TrieNode() }
            currentNode.wordCount++
        }
        currentNode.isEndOfWord = true
    }

    fun calculatePrefixScore(word: String): Int {
        var currentNode = root
        var score = 0
        for (char in word) {
            currentNode = currentNode.children[char] ?: return score // Si no hay más prefijos
            score += currentNode.wordCount
        }
        return score
    }
}