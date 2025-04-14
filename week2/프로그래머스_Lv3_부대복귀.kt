import java.util.*

class Solution {
    fun solution(n: Int, roads: Array<IntArray>, sources: IntArray, destination: Int): IntArray {
        var answer: IntArray = intArrayOf()
        
        val road = Array(n) { mutableListOf<Int>() }
        val distance = IntArray(n) { -1 }
        val queue: Queue<Int> = LinkedList<Int>()
        
        roads.forEach {
            road[it[0] - 1].add(it[1] - 1)
            road[it[1] - 1].add(it[0] - 1)
        }
        
        queue.add(destination - 1)
        distance[destination - 1] = 0
    
        while (queue.isNotEmpty()) {
            val now = queue.poll()
            
            road[now].forEach {
                if (distance[it] == -1) {
                    distance[it] = distance[now] + 1
                    queue.add(it)
                }
            }
        }
        
        sources.forEach {
            answer += distance[it - 1]
        }
        
        return answer
    }
}
