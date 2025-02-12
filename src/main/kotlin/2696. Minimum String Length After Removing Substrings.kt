fun minLength(s: String): Int {

    var flag = false
    var temp = s
    do {
        flag = false
        if(temp.contains("AB")){
            temp = temp.replace("AB","")
            flag=true
        }
        if(temp.contains("CD")){
            temp = temp.replace("CD","")
            flag=true
        }
    } while (flag && temp.isNotEmpty())

    return temp.length
}


fun minLength2(s: String): Int {
    val stack = mutableListOf<Char>()

    for (char in s) {
        stack.add(char)
        if (stack.size >= 2) {
            val lastTwo = stack.takeLast(2).joinToString("")
            if (lastTwo == "AB" || lastTwo == "CD") {
                stack.removeAt(stack.size - 1)
                stack.removeAt(stack.size - 1)
            }
        }
    }

    return stack.size
}