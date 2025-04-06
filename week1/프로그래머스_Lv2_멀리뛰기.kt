class Solution {
    fun solution(n: Int): Long {
        val answer = LongArray(2001) { 0 }
        
        answer[1] = 1
        answer[2] = 2
        
        for (i in 3..n) {
            answer[i] = (answer[i - 1] + answer[i - 2]) % 1234567
        }
        
        return answer[n]
    }
}
