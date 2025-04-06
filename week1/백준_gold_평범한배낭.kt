import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val bufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val bufferedWriter = BufferedWriter(OutputStreamWriter(System.`out`))

    val (n, k) = bufferedReader.readLine().split(" ").map { it.toInt() }
    var weight = arrayOf<Pair<Int, Int>>()
    val dp = Array(n + 1) { IntArray(k + 1) { 0 } }

    repeat(n) {
        val (w, v) = bufferedReader.readLine().split(" ").map { it.toInt() }
        weight += Pair(w, v)
    }

    for (i in 1..n) {
        for (j in 0..k) {
            if (j >= weight[i - 1].first) dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i - 1].first] + weight[i - 1].second)
            else dp[i][j] = dp[i - 1][j]
        }
    }

    bufferedWriter.write(dp[n][k].toString())

    bufferedWriter.flush()
    bufferedWriter.close()
}
