fun splitListToParts(head: ListNode?, k: Int): Array<ListNode?> {
    val result = Array<ListNode?>(k) { null }

    var count = 0
    var tempHead = head


    while (tempHead != null) {
        count++
        tempHead = tempHead.next
    }

    val elementsByPart = count / k
    val elementsWithExtraOne = count % k

    tempHead = head

    for (i in 0 until k) {
        if (tempHead == null) break
        result[i] = tempHead

        val partSize = elementsByPart + if (i < elementsWithExtraOne) 1 else 0

        for (j in 0 until partSize - 1) {
            tempHead = tempHead?.next
        }

        val nextPartHead = tempHead?.next
        tempHead?.next = null
        tempHead = nextPartHead
    }

    return result
}