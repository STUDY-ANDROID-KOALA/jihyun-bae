package org.sopt.boj

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val bufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val bufferedWriter = BufferedWriter(OutputStreamWriter(System.`out`))

    val (n, m, l, k) = bufferedReader.readLine().split(" ").map { it.toInt() }

    val stars = Array(k) { bufferedReader.readLine().split(" ").map { it.toInt() } }

    var answer = 0

    for (i in stars.indices) {
        for (j in stars.indices) {
            val start = arrayOf(Math.min(stars[i][0], stars[j][0]), Math.min(stars[i][1], stars[j][1]))

            var count = 0

            for (star in stars) {
                if (start[0] <= star[0] && star[0] <= start[0] + l && start[1] <= star[1] && star[1] <= start[1] + l) count++
            }
            answer = Math.max(answer, count)
        }
    }

    bufferedWriter.write((k - answer).toString())

    bufferedWriter.flush()
    bufferedWriter.close()
}
