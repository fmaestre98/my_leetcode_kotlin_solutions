import java.util.PriorityQueue

fun main() {
    println(longestDiverseString(0,0,0))
}

fun longestDiverseString(a: Int, b: Int, c: Int): String {

    val response = StringBuilder("")
    val priorityQueue = PriorityQueue<Pair<Char, Int>>(compareByDescending { it.second })
    priorityQueue.add(Pair('a', a))
    priorityQueue.add(Pair('b', b))
    priorityQueue.add(Pair('c', c))

    var temp: Pair<Char, Int>
    while (!priorityQueue.isEmpty()) {
        temp = priorityQueue.poll()
        if(priorityQueue.isNotEmpty() && response.isNotEmpty() && response.last() == temp.first){
            val skip = priorityQueue.poll()
            priorityQueue.add(temp)
            temp = skip
        }
        if (temp.second >= 2 && (priorityQueue.isNotEmpty() && temp.second - priorityQueue.peek().second > 2) || priorityQueue.isEmpty()) {
            response.append(temp.first)
            response.append(temp.first)
            temp = Pair(temp.first, temp.second - 2)
        } else {
            response.append(temp.first)
            temp = Pair(temp.first, temp.second - 1)
        }
        if(temp.second>0){
            priorityQueue.add(temp)
        }

        if(priorityQueue.size == 1 && response.isNotEmpty() && priorityQueue.peek().first == response.last()){
           return response.toString()
        }
    }


    return response.toString()
}