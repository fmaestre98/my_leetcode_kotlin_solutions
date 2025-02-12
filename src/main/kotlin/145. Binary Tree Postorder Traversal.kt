fun main() {

}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

fun postorderTraversal(root: TreeNode?): List<Int> {
    val response: MutableList<Int> = mutableListOf()
    postorderTraversalUtil(root, response)
    return response
}

fun postorderTraversalUtil(root: TreeNode?, list: MutableList<Int>) {
    if (root == null) return
    postorderTraversalUtil(root.left, list)
    postorderTraversalUtil(root.right, list)
    list.add(root.`val`)
}
