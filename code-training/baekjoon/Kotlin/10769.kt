import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

// 10769
fun main() {
  val br = BufferedReader(InputStreamReader(System.`in`))
  val bw = BufferedWriter(OutputStreamWriter(System.out))
  // Initialize the pair list
  // val pairList = mutableListOf<Pair<Int, Int>>()
  val n = br.readLine()
  var h = Regex(Regex.escape(":-)")).findAll(n).count() //contains("1")
  var uh = Regex(Regex.escape(":-(")).findAll(n).count()
  val result = when {
      h>uh -> "happy"
      h<uh -> "sad"
      h>0&&h==uh&&uh>0 -> "unsure"
      else -> "none"
  }
  //bw.write("${h} ${uh}")
  bw.write("${result}")
  bw.flush()
  bw.close()
}
