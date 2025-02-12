fun isCircularSentence(sentence: String): Boolean {
    val words = sentence.split(" ")
    if (words[0].first() != words[words.size - 1].last()) {
        return false
    }
    for (i in 0 until words.size - 1) {
        if (words[i].last() != words[i + 1].first()) {
            return false
        }
    }
    return true
}


fun isCircularSentence2(sentence: String): Boolean {
    var prevChar = sentence.last() // toma el último carácter de la cadena
    var i = 0

    while (i < sentence.length) {
        val currentWordStart = i
        while (i < sentence.length && sentence[i] != ' ') {
            i++
        }

        if (prevChar != sentence[currentWordStart]) {
            return false
        }

        prevChar = sentence[i - 1]

        i++
    }

    return prevChar == sentence.first()
}