import java.util.LinkedList
import java.util.Queue

class Solution {
    fun solution(n: Int, edge: Array<IntArray>): Int {
        val graph = Array(n) { mutableListOf<Int>() }
        val visited = IntArray(n) { 0 }
        val queue: Queue<Int> = LinkedList<Int>()
        
        edge.forEach {
            graph[it[0] - 1].add(it[1] - 1)
            graph[it[1] - 1].add(it[0] - 1)
        }
        
        queue.add(0)
        visited[0] = 1
        
        while(queue.isNotEmpty()) {
            val now = queue.poll()
            
            for (i in graph.indices) {
                if (visited[i] == 0 && graph[now].contains(i)) {
                    visited[i] = visited[now] + 1
                    queue.add(i)
                }
            }
        }
        
        return visited.count { it == visited.maxOrNull() ?: 1 }
    }
} 
