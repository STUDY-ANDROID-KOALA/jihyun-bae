import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val bufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val bufferedWriter = BufferedWriter(OutputStreamWriter(System.`out`))

    val s = bufferedReader.readLine()
    val t = bufferedReader.readLine()
    var answer = 0

    fun dfs(input: String) {
        if (s == input) {
            answer = 1
            return
        }

        if (input == "") return

        if (input.last() == 'A') dfs(input.dropLast(1))
        if (input.first() == 'B') dfs(input.drop(1).reversed())
    }

    dfs(t)

    bufferedWriter.write(answer.toString())

    bufferedWriter.flush()
    bufferedWriter.close()
}
