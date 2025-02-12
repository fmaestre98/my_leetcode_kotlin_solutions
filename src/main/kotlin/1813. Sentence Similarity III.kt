import kotlin.math.min

fun main() {
    println(areSentencesSimilar3("qbaVXO Msgr aEWD v ekcb", "qbaVXO Msgr aEWD v ekcb"))

    println(areSentencesSimilar3("qbaVXO Msgr aEWD v ekcb", "Msgr aEWD ekcb"))

}

fun areSentencesSimilar(sentence1: String, sentence2: String): Boolean {

    val sentence1Array = sentence1.split(" ")
    val sentence2Array = sentence2.split(" ")

    var longestCommonSuffix = 0
    var longestCommonPrefix = 0
    val minSize = min(sentence1Array.size, sentence2Array.size)
    var i = 0

    while (i < sentence1Array.size && i < sentence2Array.size) {
        if (sentence1Array[i] == sentence2Array[i]) {
            longestCommonPrefix++
        } else {
            break
        }
        i++
    }

    i = sentence1Array.size - 1
    var j = sentence2Array.size - 1
    while (i >= 0 && j >= 0) {
        if (sentence1Array[i] == sentence2Array[j]) {
            longestCommonSuffix++
        } else {
            break
        }
        i--
        j--
    }

    return (longestCommonPrefix + longestCommonSuffix) == minSize
}

fun areSentencesSimilar2(sentence1: String, sentence2: String): Boolean {
    val sentence1Array = sentence1.split(" ")
    val sentence2Array = sentence2.split(" ")

    var longestCommonPrefix = 0
    var longestCommonSuffix = 0

    val minSize = Math.min(sentence1Array.size, sentence2Array.size)

    while (longestCommonPrefix < minSize && sentence1Array[longestCommonPrefix] == sentence2Array[longestCommonPrefix]) {
        longestCommonPrefix++
    }

    while (longestCommonSuffix < minSize - longestCommonPrefix &&
        sentence1Array[sentence1Array.size - 1 - longestCommonSuffix] ==
        sentence2Array[sentence2Array.size - 1 - longestCommonSuffix]
    ) {
        longestCommonSuffix++
    }

    return (longestCommonPrefix + longestCommonSuffix) == minSize ||
            sentence1Array.size == sentence2Array.size &&
            (longestCommonPrefix + longestCommonSuffix) == sentence2Array.size * 2
}


fun areSentencesSimilar3(sentence1: String, sentence2: String): Boolean {
    val words1 = sentence1.split(" ")
    val words2 = sentence2.split(" ")

    var left = 0
    var right = 0

    while (left < words1.size && left < words2.size && words1[left] == words2[left]) {
        left++
    }

    while (right < words1.size - left && right < words2.size - left &&
        words1[words1.size - 1 - right] == words2[words2.size - 1 - right]
    ) {
        right++
    }

    return left + right == words1.size || left + right == words2.size ||
            words1.size == words2.size && left + right == words1.size * 2
}