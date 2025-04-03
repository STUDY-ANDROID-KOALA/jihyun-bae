import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val bufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val bufferedWriter = BufferedWriter(OutputStreamWriter(System.`out`))

    val t = bufferedReader.readLine().toInt()
    val dp = IntArray(10001) { 1 }

    for (i in 2..10000) {
        dp[i] += dp[i - 2]
    }

    for (i in 3..10000) {
        dp[i] += dp[i - 3]
    }

    repeat(t) {
        bufferedWriter.write(dp[bufferedReader.readLine().toInt()].toString())
        bufferedWriter.newLine()
    }

    bufferedWriter.flush()
    bufferedWriter.close()
}
