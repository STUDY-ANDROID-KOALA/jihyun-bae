class Solution {
    fun solution(scores: Array<IntArray>): Int {
        var answer: Int = 1
        
        val temp = scores.sortedWith(compareBy({-it[0]}, {it[1]}))
        var max = temp[0][1]
        
        for (score in temp.indices) {
            if (temp[score][1] < max) {
                if (temp[score][0] == scores[0][0] && temp[score][1] == scores[0][1]) return -1
                continue
            }
            if (temp[score][0] + temp[score][1] > scores[0][0] + scores[0][1]) answer++
            max = Math.max(max, temp[score][1])
        }
        
        return answer
    }
}
