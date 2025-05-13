class Solution {
    fun solution(n: Int, m: Int, x: Int, y: Int, r: Int, c: Int, k: Int): String {
        val d = listOf(Triple(1, 0, "d"), Triple(0, -1, "l"), Triple(0, 1, "r"), Triple(-1, 0, "u"))
        var answer = ""
        
        fun dfs(way: String, now: Pair<Int, Int>) {
            val remain = k - way.length
            val dist = Math.abs(now.first - r) + Math.abs(now.second - c)
            
            if (remain < dist || (remain - dist) % 2 != 0) return
            
            if (answer != "") return
            
            if (way.length == k) {
                if (now.first == r && now.second == c) answer = way
                return
            }
            
            for (i in d.indices) {
                val next = Pair(now.first + d[i].first, now.second + d[i].second)
                
                if (next.first > 0 && next.first <= n && next.second > 0 && next.second <= m) {
                    dfs(way + d[i].third, next)
                }
            }
        }
        
        dfs("", Pair(x, y))
        
        return if(answer == "") "impossible" else answer
    }
}
