fun main() {
    println(checkInclusion("adc","dcmda"))
}

fun checkInclusion(s1: String, s2: String): Boolean {
    val s1Length = s1.length
    val s2Length = s2.length

    if(s2Length<s1Length){
        return false
    }
    for (i in 0..s2Length-s1Length){
       if(checkPermutation(s1, s2.substring(i, i+s1Length))){
           return true
       }
    }

    return false
}

fun checkPermutation(s1: String, s2: String): Boolean{
     val map = mutableMapOf<Char, Int>()
    for (c in s1){
       map[c] = map.computeIfAbsent(c){0}+1
    }
    for (c in s2){
        if(map.containsKey(c) && map[c]!!>0){
          map[c]=map[c]!!-1
        }else{
         return false
        }
    }
    return true
}

fun checkInclusion2(s1: String, s2: String): Boolean {
    val s1Freq = IntArray(26)
    val s2Freq = IntArray(26)
    val s1Length = s1.length
    val s2Length = s2.length

    if(s2Length<s1Length){
        return false
    }

    for (c in s1) {
        s1Freq[c - 'a']++
    }

    for (i in 0 until s1Length) {
        s2Freq[s2[i] - 'a']++
    }

    if (s1Freq.contentEquals(s2Freq)) {
        return true
    }

    for (i in s1Length until s2Length) {
        s2Freq[s2[i] - 'a']++
        s2Freq[s2[i - s1Length] - 'a']--

        if (s1Freq.contentEquals(s2Freq)) {
            return true
        }
    }

    return false
}