import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val bufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val bufferedWriter = BufferedWriter(OutputStreamWriter(System.`out`))

    val n = bufferedReader.readLine().toInt()
    val meetings = Array(n) { bufferedReader.readLine().split(" ").map { it.toInt() } }

    meetings.sortWith(compareBy({ it[1] }, { it[0] }))

    var answer = 1
    var now = meetings[0][1]

    for (meeting in 1..meetings.size - 1) {
        if (meetings[meeting][0] >= now) {
            answer += 1
            now = meetings[meeting][1]
        }
    }

    bufferedWriter.write(answer.toString())

    bufferedWriter.flush()
    bufferedWriter.close()
}
