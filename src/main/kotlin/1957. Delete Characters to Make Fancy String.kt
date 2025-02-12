fun makeFancyString(s: String): String {
    val response = StringBuilder("")
    var cont = 0
    var previousChar = '-'
    for (c in s) {
        if (c == previousChar) {
           cont++
            if (cont<3) {
                response.append(c)
            }
        } else {
            previousChar = c
            cont = 1
            response.append(c)
        }
    }
    return response.toString()
}


fun makeFancyString2(s: String): String {
    val response = StringBuilder()
    var count = 1

    for (i in 1 until s.length) {
        if (s[i] == s[i - 1]) {
            count++
            if (count < 3) {
                response.append(s[i])
            }
        } else {
            response.append(s[i])
            count = 1
        }
    }

    if (s.isNotEmpty()) {
        response.insert(0, s[0])
    }

    return response.toString()
}