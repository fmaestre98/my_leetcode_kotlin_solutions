import java.util.*

fun canBeValid(s: String, locked: String): Boolean {

    if (s.length % 2 != 0) return false
    val unlocked = Stack<Int>()
    val openStack = Stack<Int>()
    for (i in s.indices) {
        if (locked[i] == '0') {
          unlocked.add(i)
        } else if(s[i] == '('){
          openStack.add(i)
        } else if(s[i] == ')'){
            if(openStack.isNotEmpty()){
                openStack.pop()
            } else if(unlocked.isNotEmpty()){
                unlocked.pop()
            } else {
                return false
            }
        }
    }

    while (openStack.isNotEmpty() && unlocked.isNotEmpty()){
        if(openStack.pop() > unlocked.pop()){
            return false
        }
    }
    return openStack.isEmpty()
}