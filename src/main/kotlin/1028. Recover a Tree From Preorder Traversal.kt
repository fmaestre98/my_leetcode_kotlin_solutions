fun main() {
    val resp = recoverFromPreorder("3")
    println("wfwesfwesf")
    println(resp);
}

fun recoverFromPreorder2(traversal: String): TreeNode? {
    if (traversal.isEmpty()) return null

    var node: TreeNode? = null
    val stack = mutableListOf<Pair<Int, TreeNode>>() //Pair<depth, value>
    var depth = 0
    var value = 0
    var index = 0
    while (index < traversal.length && traversal[index].isDigit()) {
        value = value * 10 + (traversal[index++] - '0');
    }
    stack.add(Pair(0, TreeNode(value)))
    while (index < traversal.length && stack.isNotEmpty()) {
        value = 0
        depth = 0
        while (index < traversal.length && !traversal[index].isDigit()) {
            depth++
            index++
        }

        while (index < traversal.length && traversal[index].isDigit()) {
            value = value * 10 + (traversal[index++] - '0');
        }

        if (stack[stack.size - 1].first < depth) {
            stack.add(Pair(depth, TreeNode(value)))
        } else {
            while (stack.size > 1 && stack[stack.size - 1].first >= depth) {
                val first = stack.removeAt(stack.size - 1).second
                val currentDepth = stack[stack.size - 1].first
                val second = stack.removeAt(stack.size - 1).second
                if (second.left == null) {
                    second.left = first
                } else {
                    second.right = first
                }
                stack.add(Pair(currentDepth, second))
                node = second
            }
            stack.add(Pair(depth, TreeNode(value)))
        }
    }

    while (stack.isNotEmpty()) {
        val last = stack.removeAt(stack.size - 1).second
        if (stack.isEmpty()) {
            node = last
        } else {
            val secondLast = stack.removeAt(stack.size - 1).second
            if (secondLast.left == null) {
                secondLast.left = last
            } else {
                secondLast.right = last
            }
            stack.add(Pair(0, secondLast))
        }
    }

    return node
}


fun recoverFromPreorder(traversal: String): TreeNode? {
    if (traversal.isEmpty()) return null

    val stack = mutableListOf<Pair<Int, TreeNode>>()
    var index = 0

    fun parseDepth(): Int {
        var depth = 0
        while (index < traversal.length && traversal[index] == '-') {
            depth++
            index++
        }
        return depth
    }

    fun parseValue(): Int {
        var value = 0
        while (index < traversal.length && traversal[index].isDigit()) {
            value = value * 10 + (traversal[index++] - '0')
        }
        return value
    }

    val rootValue = parseValue()
    stack.add(Pair(0, TreeNode(rootValue)))

    while (index < traversal.length) {
        val depth = parseDepth()
        val value = parseValue()

        val newNode = TreeNode(value)

        while (stack.isNotEmpty() && stack.last().first >= depth) {
            val (_, node) = stack.removeAt(stack.size - 1)
            stack.lastOrNull()?.let { (_, parent) ->
                if (parent.left == null) {
                    parent.left = node
                } else {
                    parent.right = node
                }
            }
        }

        stack.add(Pair(depth, newNode))
    }

    while (stack.size > 1) {
        val (_, node) = stack.removeAt(stack.size - 1)
        stack.last().let { (_, parent) ->
            if (parent.left == null) {
                parent.left = node
            } else {
                parent.right = node
            }
        }
    }

    return stack.firstOrNull()?.second
}