import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val bufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val bufferedWriter = BufferedWriter(OutputStreamWriter(System.`out`))

    val first = bufferedReader.readLine()
    val second = bufferedReader.readLine()
    val dp = Array(first.length + 1) { IntArray(second.length + 1) }

    for (i in 1..first.length) {
        for (j in 1..second.length) {
            if (first[i - 1] == second[j - 1]) dp[i][j] = dp[i - 1][j - 1] + 1
            else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1])
        }
    }
    
    bufferedWriter.write(dp.maxOf { it.maxOrNull() ?: Int.MIN_VALUE }.toString())

    bufferedWriter.flush()
    bufferedWriter.close()
}
