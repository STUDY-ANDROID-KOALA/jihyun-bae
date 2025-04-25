class Solution {
    fun solution(s: String): Int {
        var answer = 0
 
        for (i in 0..s.length - 1) {
            var odd = 0
            while (i - odd - 1 >= 0 && i + odd + 1 < s.length && s[i - odd - 1] == s[i + odd + 1]) odd++
            answer = Math.max(answer, 1 + odd * 2)
            
            var even = 0
            while (i - even >= 0 && i + even + 1 < s.length && s[i - even] == s[i + even + 1]) even++
            answer = Math.max(answer, even * 2)
        }

        return answer
    }
}
