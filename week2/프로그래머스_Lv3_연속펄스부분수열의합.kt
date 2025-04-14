class Solution {
    fun solution(sequence: IntArray): Long {
        var answer: Long = -Long.MIN_VALUE
        
        var sum1 = 0L
        var sum2 = 0L
        var sum1Min = 0L
        var sum2Min = 0L
        var pulse = 1
        
        sequence.forEach {
            sum1 += it * pulse
            sum2 += it * -1 * pulse
            
            answer = maxOf(answer, sum1 - sum1Min, sum2 - sum2Min)
            
            sum1Min = Math.min(sum1Min, sum1)
            sum2Min = Math.min(sum2Min, sum2)
            
            pulse = pulse * -1
        }
        
        return answer
    }
}
