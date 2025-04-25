class Solution {
    fun solution(n: Int, times: IntArray): Long {
        var min = 0L
        var max = (times.maxOrNull() ?: 0).toLong() * n.toLong()
        
        while (min <= max) {
            val mid = (min + max) / 2
            var people = 0L
            
            for (time in times.indices) {
                people += mid / times[time]
                
                if (people >= n) break
            }
            
            if (people >= n) max = mid - 1
            else min = mid + 1
        }
        
        return min
    }
}
