import java.util.*


fun minGroups(intervals: Array<IntArray>): Int {
  val sortedIntervals = intervals.sortedArrayWith(compareBy<IntArray> { it[0] }.thenBy { it[1] })

  val minHeap = PriorityQueue<Int>()

  for (interval in sortedIntervals) {
    val start = interval[0]
    val end = interval[1]

    if (minHeap.isNotEmpty() && minHeap.peek() < start) {
      minHeap.poll()
    }

    minHeap.add(end)
  }

  return minHeap.size
}