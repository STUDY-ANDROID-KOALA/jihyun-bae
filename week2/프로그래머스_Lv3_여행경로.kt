class Solution {
    fun solution(tickets: Array<Array<String>>): Array<String> {
        var answer = arrayOf<String>()
        val visited = BooleanArray(tickets.size) { false }
        tickets.sortWith(compareBy({ it[0] }, { it[1] }))
        
        fun dfs(now: String, route: String, depth: Int) {
            if (answer.isNotEmpty()) return
            
            if (depth == tickets.size) {
                println(now + "  " + route + "  " + depth)
                answer = route.split(" ").toTypedArray()
                return
            }
            
            for (i in tickets.indices) {
                if (!visited[i] && tickets[i][0] == now) {
                    visited[i] = true
                    dfs(tickets[i][1], route + " " + tickets[i][1], depth + 1)
                    visited[i] = false
                }
            }
        }
        
        dfs("ICN", "ICN", 0)
        
        return answer
    }
}
