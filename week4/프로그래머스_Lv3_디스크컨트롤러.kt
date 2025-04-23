import java.util.*

class Solution {
    fun solution(jobs: Array<IntArray>): Int {
        var answer = 0
        val queue = PriorityQueue(compareBy<Triple<Int, Int, Int>> { it.first }
    .thenBy { it.second }
    .thenBy { it.third })
        
        jobs.sortBy { it[0] }
        var now = 0
        var index = 0
        
        while (index < jobs.size || queue.isNotEmpty()) {
            while(index < jobs.size && now >= jobs[index][0]) {
                queue.add(Triple(jobs[index][1], jobs[index][0], index))
                index++
            }
            
            if (queue.isNotEmpty()) {
                val task = queue.poll()
                now += task.first
                answer += now - task.second
            } else {
                now = jobs[index][0]
            }
        }
        
        return answer / jobs.size
    }
}
