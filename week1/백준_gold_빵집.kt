import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val bufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val bufferedWriter = BufferedWriter(OutputStreamWriter(System.`out`))

    val (r, c) = bufferedReader.readLine().split(" ").map { it.toInt() }
    val map = Array(r) { bufferedReader.readLine().toCharArray() }
    val way = arrayOf(Pair(-1, 1), Pair(0, 1), Pair(1, 1))
    val answer = BooleanArray(r) { false }

    fun dfs(now: Pair<Int, Int>, start: Int) {
        if (answer[start]) return

        map[now.first][now.second] = 'x'

        if (now.second == c - 1) {
            answer[start] = true
            return
        }

        for (i in way.indices) {
            val next = Pair(now.first + way[i].first, now.second + way[i].second)

            if (next.first < 0 || next.first >= r || next.second < 0 || next.second >= c) continue

            if (map[next.first][next.second] == '.') {
                dfs(next, start)
            }
        }
    }

    for (i in 0..<r) {
        dfs(Pair(i, 0), i)
    }

    bufferedWriter.write(answer.filter { it }.size.toString())

    bufferedWriter.flush()
    bufferedWriter.close()
}
