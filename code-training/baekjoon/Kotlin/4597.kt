import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

fun main() {
  val br = BufferedReader(InputStreamReader(System.`in`))
  val bw = BufferedWriter(OutputStreamWriter(System.out))

  while (true) {
    var s = StringBuilder(br.readLine())
    if (s.toString().equals("#")) {
      break
    }
    var n = s.count { it == '1' }
    var c = if (n % 2 == 0) 'e' else 'o'
    s[s.lastIndex] = if (s[s.lastIndex] == c) '0' else '1'
    bw.write("${s}\n")
  }
  bw.flush()
  bw.close()
}
