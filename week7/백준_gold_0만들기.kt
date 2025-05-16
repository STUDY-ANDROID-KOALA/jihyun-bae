import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val bufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val bufferedWriter = BufferedWriter(OutputStreamWriter(System.`out`))

    val t = bufferedReader.readLine().toInt()
    val operators = listOf(' ', '+', '-')

    fun Int.check(txt: String, next: Int) {
        if (next > this) {
            val numbers = txt.replace(" ", "").split("[+\\-]".toRegex()).map { it.toInt() }.toMutableList()
            val operator = txt.filter { it == '+' || it == '-' }


            for (i in operator.indices) {
                when (operator[i]) {
                    '+' -> numbers[i + 1] = numbers[i] + numbers[i + 1]
                    '-' -> numbers[i + 1] = numbers[i] - numbers[i + 1]
                }
            }

            if (numbers[numbers.size - 1] == 0) {
                bufferedWriter.write(txt)
                bufferedWriter.newLine()
            }

            return
        }

        for (operator in operators) {
            this.check(txt + operator + next, next + 1)
        }
    }

    repeat(t) {
        val n = bufferedReader.readLine().toInt()

        n.check("1", 2)
        bufferedWriter.newLine()
    }

    bufferedWriter.flush()
    bufferedWriter.close()
}
