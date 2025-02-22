
fun constructSequenceUtil(
    array: IntArray,
    n: Int,
    currentStep: Int = 0,
    visited: BooleanArray = BooleanArray(n + 1)
): Boolean {
    if (currentStep == array.size) {
        return true
    }

    if (array[currentStep] != 0) {
        return constructSequenceUtil(array, n, currentStep + 1, visited)
    }

    for (i in n downTo 1) {
        if (!visited[i]) {
            if (i == 1) {
                array[currentStep] = i
                visited[i] = true
                if (constructSequenceUtil(array, n, currentStep + 1, visited)) {
                    return true
                }
                array[currentStep] = 0
                visited[i] = false
            } else if (currentStep + i < array.size && array[currentStep + i] == 0) {
                array[currentStep] = i
                array[currentStep + i] = i
                visited[i] = true
                if (constructSequenceUtil(array, n, currentStep + 1, visited)) {
                    return true
                }
                array[currentStep] = 0
                array[currentStep + i] = 0
                visited[i] = false
            }
        }
    }

    return false
}

fun constructDistancedSequence(n: Int): IntArray {
    val array = IntArray(2 * n - 1)
    constructSequenceUtil(array, n)
    return array
}

fun main() {
    val n = 3
    val sequence = constructDistancedSequence(n)
    println(sequence.joinToString(", "))
}