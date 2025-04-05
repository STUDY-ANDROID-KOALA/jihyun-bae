class Solution {
    fun solution(genres: Array<String>, plays: IntArray): IntArray {
        val map = mutableMapOf<String, MutableList<Pair<Int, Int>>>()
        
        for (i in genres.indices) {
            map.getOrPut(genres[i]) { mutableListOf() }.add(Pair(i, plays[i]))
        }
        
        return map.entries.sortedByDescending { it.value.sumOf { it.second } }
            .flatMap { (_, playList) -> playList.sortedByDescending { it.second }.take(2).map { it.first } }.toIntArray()
    }
}
