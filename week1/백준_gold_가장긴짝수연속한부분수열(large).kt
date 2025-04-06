import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val bufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val bufferedWriter = BufferedWriter(OutputStreamWriter(System.`out`))

    val (n, k) = bufferedReader.readLine().split(" ").map { it.toInt() }
    val s = bufferedReader.readLine().split(" ").map { it.toInt() }

    var answer = 0
    var start = 0
    var end = 0
    var odd = 0

    while (end < n && start < n) {
        if (s[start] % 2 == 1) {
            if (s[start] % 2 == 1 && odd > 0) odd--
            start++
        }
        else if (start > end) end++
        else {
            end++

            if (end >= n) {
                answer = Math.max(answer, n - start - odd)
            } else {
                if (s[end] % 2 == 1) odd++

                if (odd > k) {
                    answer = Math.max(answer, end - start + 1 - odd)
                    if (s[start] % 2 == 1) odd--
                    start++
                }
            }
        }
    }

    if (start == 0 && end == 0) answer = Math.max(answer, if(s[start] % 2 == 1) 0 else 1)

    bufferedWriter.write(answer.toString())

    bufferedWriter.flush()
    bufferedWriter.close()
}
