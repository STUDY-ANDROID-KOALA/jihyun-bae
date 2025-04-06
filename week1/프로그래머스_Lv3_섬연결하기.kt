class Solution {
    fun solution(n: Int, costs: Array<IntArray>): Int {
        var answer = 0
        val visited = BooleanArray(n) { false }
        val way = mutableListOf<IntArray>()
        
        visited[0] = true
        costs.forEach { cost ->
            if (cost[0] == 0 || cost[1] == 0) way.add(cost)
        }
        
        while(!visited.all { it }) {
            way.sortBy { it[2] }
            
            Loop@for(i in way.indices) {
                if (visited[way[i][0]] != visited[way[i][1]]) {
                    answer += way[i][2]
                    
                    if (!visited[way[i][0]]) {
                        visited[way[i][0]] = true
                        costs.forEach { cost ->
                            if ((cost[0] == way[i][0] && !visited[cost[1]]) || (cost[1] == way[i][0] && !visited[cost[0]])) way.add(cost)
                        }
                    } else if (!visited[way[i][1]]) {
                        visited[way[i][1]] = true
                        costs.forEach { cost ->
                            if ((cost[0] == way[i][1] && !visited[cost[1]]) || (cost[1] == way[i][1] && !visited[cost[0]])) way.add(cost)
                        }
                    }
                    
                    break@Loop
                }
            }
        }   
        
        return answer
    }
}
