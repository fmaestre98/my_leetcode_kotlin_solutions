import java.util.*

fun largestValues(root: TreeNode?): List<Int> {
    val result = mutableListOf<Int>()
    if (root == null) return result

    val queue: Queue<TreeNode> = LinkedList()
    queue.add(root)

    while (queue.isNotEmpty()) {
        var levelMax = Int.MIN_VALUE
        val levelSize = queue.size

        for (i in 0 until levelSize) {
            val node = queue.poll()
            if (node.`val` > levelMax) {
                levelMax = node.`val`
            }

            node.left?.let { queue.add(it) }
            node.right?.let { queue.add(it) }
        }
        result.add(levelMax)
    }
    return result
}