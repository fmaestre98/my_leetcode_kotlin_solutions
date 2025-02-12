fun swapPairs(head: ListNode?): ListNode? {
    var prev: ListNode = ListNode(-1)
    prev.next = head
    var dummy = prev
    var current: ListNode? = head

    while (current?.next != null){
        val second: ListNode? = current.next
        val temp: ListNode? = current.next?.next
        second?.next = current
        current.next = temp
        prev.next = second

        prev = current
        current = temp
    }


        return dummy.next
}