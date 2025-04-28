class Solution {
    fun solution(n: Int, results: Array<IntArray>): Int {
        var answer = 0
        val way = Array(n) { IntArray(n) { 0 } }
        
        for (result in results.indices) {
            way[results[result][0] - 1][results[result][1] - 1] = 1
            way[results[result][1] - 1][results[result][0] - 1] = -1
        }
        
        for (i in way.indices) {
            for (j in way.indices) {
                for (k in way.indices) {
                    if (way[j][i] == -1 && way[i][k] == -1) {
                        way[j][k] = -1
                        way[k][j] = 1
                    }
                    
                    if (way[j][i] == 1 && way[i][k] == 1) {
                        way[j][k] = 1
                        way[k][j] = -1
                    }
                }
            }
        }
        
        for (i in way.indices) {
            if (way[i]
                .filterIndexed { index, _ -> index != i }
                .reduce { temp, i -> temp * i } != 0
               ) answer++
        }
        
        return answer
    }
}
