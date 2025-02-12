fun countPrefixSuffixPairs(words: Array<String>): Int {
     var count = 0
    for (i in 0 until words.size-1){
        for (j in i+1 until words.size){
            count += if(isPrefixAndSuffix(words[i], words[j])) 1 else 0
        }
    }
    return count
}


fun isPrefixAndSuffix(str1: String, str2: String): Boolean {
    return str2.startsWith(str1) && str2.endsWith(str1)
}