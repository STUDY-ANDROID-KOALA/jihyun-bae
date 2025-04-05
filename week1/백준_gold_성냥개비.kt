package org.sopt.boj

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val bufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val bufferedWriter = BufferedWriter(OutputStreamWriter(System.`out`))

    val min = LongArray(101) { Long.MAX_VALUE }
    min[2] = 1
    min[3] = 7
    min[4] = 4
    min[5] = 2
    min[6] = 6
    min[7] = 8
    min[8] = 10
    val array = intArrayOf(0, 0, 1, 7, 4, 2, 0, 8)

    for (i in 9..100) {
        for (j in 2..7) {
            min[i] = Math.min(min[i], min[i - j] * 10 + array[j])
        }
    }

    val t = bufferedReader.readLine().toInt()

    repeat(t) {
        val num = bufferedReader.readLine().toInt()

        val max = IntArray(num / 2) { 1 }
        if (num % 2 == 1) max[0] = 7

        bufferedWriter.write(min[num].toString() + " " + max.joinToString(""))
        bufferedWriter.newLine()
    }

    bufferedWriter.flush()
    bufferedWriter.close()
}
