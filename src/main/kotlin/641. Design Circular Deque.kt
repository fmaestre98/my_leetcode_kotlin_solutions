data class CircularDequeNode(var value: Int) {
    var next: CircularDequeNode? = null
    var prev: CircularDequeNode? = null
}

class MyCircularDeque(private val maxSize: Int) {

    private var front: CircularDequeNode? = null
    private var rear: CircularDequeNode? = null
    private var currentSize = 0

    fun insertFront(value: Int): Boolean {
        if (isFull()) return false

        val newNode = CircularDequeNode(value)
        if (isEmpty()) { // Si está vacío, nuevo nodo es tanto front como rear
            front = newNode
            rear = newNode
        } else {
            // Insertar en frente
            newNode.next = front
            front!!.prev = newNode
            front = newNode
        }
        currentSize++
        return true
    }

    fun insertLast(value: Int): Boolean {
        if (isFull()) return false

        val newNode = CircularDequeNode(value)
        if (isEmpty()) { // Si está vacío, nuevo nodo es tanto front como rear
            front = newNode
            rear = newNode
        } else {
            // Insertar al final
            newNode.prev = rear
            rear!!.next = newNode
            rear = newNode
        }
        currentSize++
        return true
    }

    fun deleteFront(): Boolean {
        if (isEmpty()) return false

        if (currentSize == 1) { // Si hay un solo elemento
            front = null
            rear = null
        } else {
            front = front?.next
            front?.prev = null // Asegúrate de que el nuevo front no tenga un prev
        }
        currentSize--
        return true
    }

    fun deleteLast(): Boolean {
        if (isEmpty()) return false

        if (currentSize == 1) { // Si hay un solo elemento
            front = null
            rear = null
        } else {
            rear = rear?.prev
            rear?.next = null // Asegúrate de que el nuevo rear no tenga un next
        }
        currentSize--
        return true
    }

    fun getFront(): Int {
        return front?.value ?: -1
    }

    fun getRear(): Int {
        return rear?.value ?: -1
    }

    fun isEmpty(): Boolean = currentSize == 0

    fun isFull(): Boolean = currentSize == maxSize
}