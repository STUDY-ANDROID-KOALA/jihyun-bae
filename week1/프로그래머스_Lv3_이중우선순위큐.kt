class Solution {
    fun solution(operations: Array<String>): IntArray {
        var queue = mutableListOf<Int>()
        
        operations.forEach {
            val (s, n) = it.split(" ")
            
            when(s) {
                "I" -> queue.add(n.toInt())
                "D" -> {
                    val target = if (n == "1") queue.maxOrNull() else queue.minOrNull()
                    
                    if (target != null) queue.remove(target)
                }
            }
        }
        
        return intArrayOf(queue.maxOrNull() ?: 0, queue.minOrNull() ?: 0)
    }
}
