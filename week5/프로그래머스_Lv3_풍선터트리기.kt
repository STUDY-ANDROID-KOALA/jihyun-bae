class Solution {
    fun solution(a: IntArray): Int {
        var answer: Int = 0
        
        var left = a[0]
        val mins = IntArray(a.size) { a[a.size - 1] }
        
        for (i in a.size - 2 downTo 0) {
            mins[i] = Math.min(mins[i + 1], a[i])
        }
        
        for (i in a.indices) {
            if (i == 0 || i == a.size - 1) {
                answer++
                continue
            }
            
            if (!(a[i] > left && a[i] > mins[i])) answer ++
            left = Math.min(left, a[i])
        }
        
        return answer
    }
}
