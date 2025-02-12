fun main() {

}
fun countConsistentStrings(allowed: String, words: Array<String>): Int {
    var res = 0
    val set = HashSet<Char>()
    allowed.forEach {
        set.add(it)
    }
    for (word in words){
        var flag = true
        word.forEach {
            if (!set.contains(it)){
                flag = false
            }
        }
        if (flag){
            res++
        }
    }
    return res
}


fun countConsistentStrings2(allowed: String, words: Array<String>): Int {
    // Convert 'allowed' string to a Set of characters for quick lookup
    val allowedSet = allowed.toSet()

    // Count how many words are consistent using the 'count' method
    return words.count { word ->
        // Check if all characters of the word are in the allowedSet
        word.all { char -> char in allowedSet }
    }
}