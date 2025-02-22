class FindElements(root: TreeNode?) {

    private val values = mutableSetOf<Int>()

    init {
        root?.let {
            it.`val` = 0
            dfs(it)
        }
    }

    private fun dfs(node: TreeNode) {
        values.add(node.`val`)

        node.left?.let {
            it.`val` = 2 * node.`val` + 1
            dfs(it)
        }

        node.right?.let {
            it.`val` = 2 * node.`val` + 2
            dfs(it)
        }
    }

    fun find(target: Int): Boolean = target in values
}