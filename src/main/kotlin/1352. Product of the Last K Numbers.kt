class ProductOfNumbers() {
    private val prefixProduct = mutableListOf<Int>()
    fun add(num: Int) {
        if (num == 0) {
            prefixProduct.clear()
        } else {
            prefixProduct.add(if (prefixProduct.isNotEmpty()) prefixProduct.last() * num else num)
        }
    }

    fun getProduct(k: Int): Int {
        if (prefixProduct.size < k) {
            return 0
        }
        return prefixProduct.last() / prefixProduct[prefixProduct.size - (k + 1)]
    }

}