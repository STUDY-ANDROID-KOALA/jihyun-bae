import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val bufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val bufferedWriter = BufferedWriter(OutputStreamWriter(System.`out`))

    val n = bufferedReader.readLine().toInt()
    val pay = Array(n) { bufferedReader.readLine().split(" ").map { it.toInt() } }
    val dp = LongArray(n) { 0 }

    for (i in pay.indices) {
        if (i != 0 ) dp[i] = Math.max(dp[i - 1], dp[i])
        for (j in Math.max(0, i - 50)..i) {
            if (j + pay[j][0] - 1 == i) {
                dp[i] = Math.max(dp[i], dp[if(j == 0) 0 else j - 1] + pay[j][1])
            }
        }
    }

    bufferedWriter.write(dp[n - 1].toString())

    bufferedWriter.flush()
    bufferedWriter.close()
}
