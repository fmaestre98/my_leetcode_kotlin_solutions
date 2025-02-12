import java.util.*

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}


fun isSubPath(head: ListNode?, root: TreeNode?): Boolean {
    if (root == null) return false

    val queue: Queue<TreeNode> = LinkedList()
    queue.add(root)

    while (queue.isNotEmpty()) {
        val currentNode = queue.poll()

        if (isSubPathHelper(head, currentNode)) {
            return true
        }

        currentNode.left?.let { queue.add(it) }
        currentNode.right?.let { queue.add(it) }
    }

    return false
}

fun isSubPathHelper(head: ListNode?, root: TreeNode?): Boolean {
    return when {
        head == null -> true
        root == null -> false
        head.`val` == root.`val` -> {
            isSubPathHelper(head.next, root.left) || isSubPathHelper(head.next, root.right)
        }
        else -> false // Los valores no coinciden
    }
}