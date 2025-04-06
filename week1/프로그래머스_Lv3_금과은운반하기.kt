class Solution {
    fun solution(a: Int, b: Int, g: IntArray, s: IntArray, w: IntArray, t: IntArray): Long {
        var start = 1L
        var end = 400000000000000L
        
        while (start < end) {
            val mid = (start + end) / 2
            
            if (check(mid, a, b, g, s, w, t)) end = mid else start = mid + 1
        }
        
        print(start.toString() + " " + end)
        
        return end
    }
    
    fun check(mid: Long, a: Int, b: Int, g: IntArray, s: IntArray, w: IntArray, t: IntArray): Boolean {
        var gold = 0L
        var silver = 0L
        var total = 0L
        
        for (i in g.indices) {
            var count = mid / (2 * t[i])
            if (mid % (2 * t[i]) >= t[i]) count++
            
            val max = Math.min((g[i] + s[i]).toLong(), w[i] * count)
            total += max
            gold += Math.min(g[i].toLong(), max)
            silver += Math.min(s[i].toLong(), max)
        }
        
        if (a <= gold && b <= silver && a + b <= total) return true
        else return false
    }
}
