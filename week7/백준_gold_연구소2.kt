import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.LinkedList
import java.util.Queue

fun main() {
    val bufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val bufferedWriter = BufferedWriter(OutputStreamWriter(System.`out`))

    val (n, m) = bufferedReader.readLine().split(" ").map { it.toInt() }
    val maps = Array(n) { bufferedReader.readLine().split(" ").map { it.toInt() } }

    val virus = mutableListOf<Pair<Int, Int>>()
    val d = listOf(Pair(1, 0), Pair(-1, 0), Pair(0, 1), Pair(0, -1))

    for (i in maps.indices) {
        for (j in maps[i].indices) {
            if (maps[i][j] == 2) virus.add(Pair(i, j))
        }
    }

    var answer = n * n

    fun dfs(now: List<Pair<Int, Int>>, next: Int) {
        if (now.size == m) {
            val queue: Queue<Pair<Int, Int>> = LinkedList<Pair<Int, Int>>()
            val visited = Array(n) { IntArray(n) { 0 } }

            for (n in now) {
                queue.add(n)
                visited[n.first][n.second] = 1
            }

            while (queue.isNotEmpty()) {
                val top = queue.poll()

                for (i in d.indices) {
                    val next = Pair(top.first + d[i].first, top.second + d[i].second)

                    if (next.first >= 0 && next.first < n && next.second >= 0 && next.second < n && maps[next.first][next.second] != 1 && visited[next.first][next.second] == 0) {
                        visited[next.first][next.second] = visited[top.first][top.second] + 1
                        queue.add(next)
                    }
                }
            }

            for (i in visited.indices) {
                for (j in visited.indices) {
                    if (visited[i][j] == 0 && maps[i][j] != 1) return
                }
            }

            answer = Math.min(answer, visited.flatMap { it.toList() }.maxOrNull() ?: answer)

            return
        }

        if (next == virus.size) return

        for (i in next..<virus.size) {
            dfs(now + virus[i], i + 1)
        }
    }

    dfs(listOf(), 0)

    bufferedWriter.write(if (answer == n * n) "-1" else (answer - 1).toString())

    bufferedWriter.flush()
    bufferedWriter.close()
}
