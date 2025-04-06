class Solution {
    fun solution(n: Int, computers: Array<IntArray>): Int {
        val visited = BooleanArray(n) { false }
        var answer = 0
        
        fun dfs(index: Int) {
            for (i in visited.indices) {
                if (computers[index][i] == 1 && !visited[i]) {
                    visited[i] = true
                    dfs(i)
                }
            }
        }
        
        for (i in visited.indices) {
            if (!visited[i]) {
                answer++
                visited[i] = true
                dfs(i)
            }
        }
        
        return answer
    }
}
