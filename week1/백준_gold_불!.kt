import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.LinkedList
import java.util.Queue

fun main() {
    val bufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val bufferedWriter = BufferedWriter(OutputStreamWriter(System.`out`))

    val (r, c) = bufferedReader.readLine().split(" ").map { it.toInt() }
    val maze = Array(r) { bufferedReader.readLine().toCharArray() }
    val fireTime = Array(r) { IntArray(c) { -1 } }
    val visited = Array(r) { IntArray(c) { -1 } }
    val queue: Queue<Pair<Int, Int>> = LinkedList<Pair<Int, Int>>()
    val move = listOf(Pair(0, -1), Pair(0, 1), Pair(-1, 0), Pair(1, 0))
    var answer = -1

    lateinit var jihun: Pair<Int, Int>

    for (i in maze.indices) {
        for (j in maze[i].indices) {
            if (maze[i][j] == 'J') jihun = Pair(i, j)
            if (maze[i][j] == 'F') {
                queue.add(Pair(i, j))
                fireTime[i][j] = 0
            }
        }
    }

    while (queue.isNotEmpty()) {
        val now = queue.poll()

        for (i in move.indices) {
            val next = Pair(now.first + move[i].first, now.second + move[i].second)

            if (next.first < 0 || next.first >= r || next.second < 0 || next.second >= c) continue

            if ((maze[next.first][next.second] == 'J' || maze[next.first][next.second] == '.') && fireTime[next.first][next.second] == -1) {
                fireTime[next.first][next.second] = fireTime[now.first][now.second] + 1
                queue.add(next)
            }
        }
    }

    if (jihun.first == r - 1 || jihun.first == 0 || jihun.second == c - 1 || jihun.second == 0) answer = 0 else queue.add(jihun)
    visited[jihun.first][jihun.second] = 0

    Loop@ while (queue.isNotEmpty()) {
        val now = queue.poll()

        for (i in move.indices) {
            val next = Pair(now.first + move[i].first, now.second + move[i].second)

            if (next.first < 0 || next.first >= r || next.second < 0 || next.second >= c) continue

            if (maze[next.first][next.second] != '#' && visited[next.first][next.second] == -1 && (fireTime[next.first][next.second] == - 1 || visited[now.first][now.second] + 1 < fireTime[next.first][next.second])) {
                visited[next.first][next.second] = visited[now.first][now.second] + 1
                queue.add(next)

                if (next.first == r - 1 || next.first == 0 || next.second == c - 1 || next.second == 0) {
                    answer = visited[next.first][next.second]
                    break@Loop
                }
            }
        }
    }

    if (answer == -1) bufferedWriter.write("IMPOSSIBLE") else bufferedWriter.write((answer + 1).toString())

    bufferedWriter.flush()
    bufferedWriter.close()
}
